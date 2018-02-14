package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.data.HibernateSession;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class LoginController implements HibernateSession {
	private static Logger log = Logger.getLogger(LoginController.class);
	private static ObjectMapper om = new ObjectMapper();
	private Session session;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User u) throws JsonProcessingException {
		Criteria cri = session.createCriteria(User.class);
		log.trace(u.getUsername());
		cri.add(Restrictions.eq("username", u.getUsername()));
		User current = (User) cri.uniqueResult();
		String json = om.writeValueAsString(current);
		log.trace(json);
		return json;
	}

	@RequestMapping(value = "/loggedIn", method = RequestMethod.GET)
	@ResponseBody
	public String getLoggedInUser(HttpSession session) throws JsonProcessingException {
		User u = (User) session.getAttribute("user");
		String json = om.writeValueAsString(u);
		log.trace(json);
		return json;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}
}
