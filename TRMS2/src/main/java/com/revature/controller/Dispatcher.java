package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.HomeDelegate;
import com.revature.delegates.SimpleRedirectDelegate;

public class Dispatcher
{
    private List<Delegate> delegates = new ArrayList<>();
    
    private void addDelegates()
    {
        // This is just the self-contained place where delegates should be added.
        // Like: add(new SomeDelegate("uri"))
        
        add(new SimpleRedirectDelegate("", "home"));
        add(new HomeDelegate("home"));
    }
    
    // This method is only here for internal convenience; so you don't have to write
    // "delegates.add()" all the time in the above method, you just need to call
    // "add()".
    private void add(Delegate d)
    {
        delegates.add(d);
    }
    
    public void init() throws ServletException
    {
        // Run the function to add delegates
        addDelegates();
        
        // After we run that, we do a sanity check to make sure we have no duplicate
        // URIs, and throw a ServletException if we do
        for (int i = 0; i < delegates.size(); i++)
        {
            String uri1 = delegates.get(i).getURI();
            for (int j = i + 1; j < delegates.size(); j++)
            {
                String uri2 = delegates.get(j).getURI();
                if (uri1.equals(uri2))
                {
                    throw new ServletException(
                            "Multiple delegates with the same URI were registered to the dispatcher!");
                }
            }
        }
    }
    
    public void dispatch(String uri, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,
            IOException
    {
        // Look for the delegate with the given URI, and process that one. Also, init it
        // if you have to.
        for (Delegate d : delegates)
        {
            if (d.getURI().equals(uri))
            {
                if (!d.isInit()) d.init();
                
                switch (req.getMethod())
                {
                    case "GET":
                        d.processGet(req, resp);
                        break;
                    case "POST":
                        d.processPost(req, resp);
                        break;
                    default:
                        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                        break;
                }
                return;
            }
        }
        
        // We couldn't find anything mapped to that URI.
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, req.getRequestURI());
    }
    
    public void destroy()
    {
        // Destroy all of them.
        for (Delegate d : delegates)
        {
            d.destroy();
        }
    }
}
