package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

@MultipartConfig
public class FrontController extends DefaultServlet
{
    private static final long serialVersionUID = -1557318745914531751L;
    private static Logger log = Logger.getLogger(FrontController.class);
    private static Dispatcher d = new Dispatcher();
    
    @Override
    public void init() throws ServletException
    {
        // Init the dispatcher
        d.init();
        super.init();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String uri = req.getRequestURI().substring(req.getContextPath().length() + 1);
        if (uri.startsWith("static/"))
        {
            log.trace("Defaulting to the Apache built-in servlet...");
            super.doGet(req, resp);
        }
        else
        {
            log.trace("Forwarding response to the dispatcher");
            d.dispatch(uri, req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
    
    @Override
    public void destroy()
    {
        // Destroy the dispatcher when the servlet gets destroyed
        d.destroy();
        super.destroy();
    }
}
