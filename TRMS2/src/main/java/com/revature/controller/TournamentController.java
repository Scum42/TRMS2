package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Tournament;
import com.revature.data.TournamentDao;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class TournamentController {

	@Autowired
	private TournamentDao tournyDao;

	private static ObjectMapper om = new ObjectMapper();

	@RequestMapping(value = "/tournament", method = RequestMethod.GET)
	@ResponseBody
	public String getTournamentAOP() throws JsonProcessingException {
		Tournament t = tournyDao.loadTournament(1);
		return om.writeValueAsString(t);
	}

}
