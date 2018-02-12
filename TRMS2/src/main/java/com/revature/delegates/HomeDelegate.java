package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.controller.Delegate;
import com.revature.util.HibernateUtil;

public class HomeDelegate extends Delegate
{
    private static Logger log = Logger.getLogger(HomeDelegate.class);
    private static HibernateUtil hu = HibernateUtil.getInstance();
    private static ObjectMapper om = new ObjectMapper();
    
    public HomeDelegate(String uri)
    {
        super(uri);
    }
    
    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Session s = hu.getSession();
        User u;
        u = s.get(User.class, 1);
        resp.getWriter().write(om.writeValueAsString(u));
    }
}
