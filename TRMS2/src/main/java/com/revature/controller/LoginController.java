package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.beans.User;
import com.revature.data.UserDao;
import com.revature.util.JsonUtil;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class LoginController {
	private static Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	UserDao udao;

	@Autowired
	JsonUtil ju;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User u, HttpSession httpSession) throws JsonProcessingException {
		User current = udao.loadUserByUsernameAndPassword(u.getUsername(), u.getPassword());
		httpSession.setAttribute("user", current);

		String json = ju.toJson(current);
		return json;
	}

	@RequestMapping(value = "/loggedIn", method = RequestMethod.GET)
	public String getLoggedInUser(HttpSession httpSession) throws JsonProcessingException {
		User u = (User) httpSession.getAttribute("user");
		log.trace("Get logged in user got " + u + " from the session");
		String json = ju.toJson(u);
		log.trace(json == null ? "JSON was null" : "JSON wasn't null and was \"" + json + "\"");
		return json;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody User u, HttpSession httpSession) throws JsonProcessingException {
		try {
			udao.persistUser(u);
			httpSession.setAttribute("user", u);
			return ju.toJson(u);
		} catch (Exception e) {
			// We have to catch this exception ourselves, because we want to
			// return json
			// "null" when the user can't be persisted, but if an exception is
			// thrown the
			// logging aspect will take over and return actual null instead of
			// json "null".
			return ju.getJsonNull();
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return ju.getJsonSuccess(true);
	}
}
