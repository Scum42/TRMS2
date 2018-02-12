package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.Delegate;

public class HomeDelegate extends Delegate
{
    public HomeDelegate(String uri)
    {
        super(uri);
    }
    
    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("static/home.html").forward(req, resp);
    }
}
