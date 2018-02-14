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
import com.revature.data.HibernateSession;

@Controller
@RequestMapping(value = "/tournament")
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class TournamentController implements HibernateSession {
	private static Logger log = Logger.getLogger(TournamentController.class);
	private static ObjectMapper om = new ObjectMapper();

	private Session session;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getTournament() throws JsonProcessingException {
		Tournament t = (Tournament) session.get(Tournament.class, 1);
		String str = om.writeValueAsString(t);
		log.trace(str);
		session.close();
		return om.writeValueAsString(t);
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}
}
