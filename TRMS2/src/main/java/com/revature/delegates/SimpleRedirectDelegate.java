package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.Delegate;

public class SimpleRedirectDelegate extends Delegate
{
    String redirectUri;
    
    public SimpleRedirectDelegate(String uri, String redirectUri)
    {
        super(uri);
        this.redirectUri = redirectUri;
    }
    
    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.sendRedirect(redirectUri);
    }
    
    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        processGet(req, resp);
    }
    
}
