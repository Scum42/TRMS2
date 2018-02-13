package com.revature.controller;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Tournament;
import com.revature.util.HibernateUtil;

@Controller
@RequestMapping(value = "/tournament")
@CrossOrigin(origins = { "http://localhost:8080" })
public class TournamentController {
	private static Logger log = Logger.getLogger(TournamentController.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();
	private static ObjectMapper om = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getTournament() throws JsonProcessingException {
		Session s = hu.getSession();
		Tournament t = (Tournament) s.get(Tournament.class, 1);
		return om.writeValueAsString(t);
	}
}
