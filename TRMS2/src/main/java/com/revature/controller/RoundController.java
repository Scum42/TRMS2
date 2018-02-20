package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.beans.Round;
import com.revature.data.RoundDao;
import com.revature.util.JsonUtil;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class RoundController {

	@Autowired
	private RoundDao rd;

	@Autowired
	JsonUtil ju;

	private static Logger log = Logger.getLogger(RoundController.class);

	@RequestMapping(value = "/tournamentrounds", method = RequestMethod.POST)
	@ResponseBody
	public String getTournamentRounds(@RequestBody int id) throws JsonProcessingException {
		List<Round> r = rd.loadRoundsByTournament(id);
		String json = ju.toJson(r);
		log.trace(json);
		return json;
	}
}
