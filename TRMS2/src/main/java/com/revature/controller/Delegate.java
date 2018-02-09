package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Delegate
{
    // This, in conjunction with initMe and destroyMe, are just ways to sanity-check
    // that init() and destroy() are never called twice in a row
    private boolean isInit = false;
    protected String uri;
    
    public Delegate(String uri)
    {
        this.uri = uri;
    }
    
    public void init()
    {
        // Only call initMe if we aren't initialized
        if (!isInit) initMe();
        isInit = true;
    }
    
    protected void initMe()
    {
        // Does nothing unless you override it
    }
    
    public boolean isInit()
    {
        return isInit;
    }
    
    // Returns the URI associated with this delegate.
    public String getURI()
    {
        return uri;
    }
    
    // Process get. This and processPost() are the main things children should be
    // overriding.
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    // Process post. This and processGet() are the main things children should be
    // overriding.
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void processConnect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void processDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void processHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void processOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void processPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void processPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void processTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Sends SC_METHOD_NOT_ALLOWED (405) unless you override it
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }    
    
    public void destroy()
    {
        // Only call destroyMe if we are initialized
        if (isInit) destroyMe();
        isInit = false;
    }
    
    protected void destroyMe()
    {
        // Does nothing unless you override it
    }
}
