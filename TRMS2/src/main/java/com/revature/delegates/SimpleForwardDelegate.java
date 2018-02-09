package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.controller.Delegate;

public class SimpleForwardDelegate extends Delegate
{
    private static Logger log = Logger.getLogger(SimpleForwardDelegate.class);
    
    private String html;
    
    public SimpleForwardDelegate(String uri, String html)
    {
        super(uri);
        this.html = html;
    }
    
    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        log.trace("Request got to " + uri);
        req.getRequestDispatcher(html).forward(req, resp);
    }
    
    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        processGet(req, resp);
    }
    
}
