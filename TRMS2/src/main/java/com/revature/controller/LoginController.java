package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.data.UserDao;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class LoginController {
	private static Logger log = Logger.getLogger(LoginController.class);
	private static ObjectMapper om = new ObjectMapper();

	@Autowired
	UserDao udao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User u, HttpSession httpSession) throws JsonProcessingException {
		User current = udao.loadUserByUsernameAndPassword(u.getUsername(), u.getPassword());
		httpSession.setAttribute("user", u);
		String json = om.writeValueAsString(current);
		return json;
	}

	@RequestMapping(value = "/loggedIn", method = RequestMethod.GET)
	@ResponseBody
	public String getLoggedInUser(HttpSession session) throws JsonProcessingException {
		User u = (User) session.getAttribute("user");
		String json = om.writeValueAsString(u);
		return json;
	}
}
