package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontController extends HttpServlet
{
    private static final long serialVersionUID = -1557318745914531751L;
    private static Logger log = Logger.getLogger(FrontController.class);
    private static Dispatcher d = new Dispatcher();
    
    @Override
    public void init() throws ServletException
    {
        // Init the dispatcher
        super.init();
        d.init();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String uri = req.getRequestURI().substring(req.getContextPath().length() + 1);
        d.dispatch(uri, req, resp);
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
