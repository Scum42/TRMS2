package com.revature.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;
import com.revature.util.HibernateUtil;

@Controller
@RequestMapping(value = "/user")
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class UserController {
	private static HibernateUtil hu = HibernateUtil.getInstance();
	private static ObjectMapper om = new ObjectMapper();
	//private static UserDao ud = new UserHibernate();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getUser() throws JsonProcessingException {
		Session s = hu.getSession();
		User u = (User) s.get(User.class, 1); //This would be getting the first user in TONY's local repository
		//User u = ud.getUser(1);
		return om.writeValueAsString(u);
	}
}
