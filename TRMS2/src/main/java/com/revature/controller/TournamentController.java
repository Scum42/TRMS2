package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Tournament;
import com.revature.util.HibernateUtilStatic;

@Controller
@RequestMapping(value = "/tournament")
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class TournamentController {
	private static Logger log = Logger.getLogger(TournamentController.class);
	private static ObjectMapper om = new ObjectMapper();
	private static HibernateUtilStatic hu = HibernateUtilStatic.getInstance();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getTournament() throws JsonProcessingException {
		Session session = hu.getSession();
		Tournament t = session.get(Tournament.class, 1);
		String str = om.writeValueAsString(t);
		log.trace(str);
		return om.writeValueAsString(t);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	@ResponseBody
	public String getAllTournaments() throws JsonProcessingException {
		Session session = hu.getSession();
		String query = "From com.revature.beans.Tournament";
		Query<Tournament> q = session.createQuery(query, Tournament.class);
		List<Tournament> tournList = q.getResultList();
		return om.writeValueAsString(tournList);
	}
}
