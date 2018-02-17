package com.revature.controller;

import java.util.List;

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
import com.revature.beans.Tournament;
import com.revature.beans.User;
import com.revature.data.TournamentDao;
import com.revature.util.JsonUtil;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class TournamentController {
	
	@Autowired
	private TournamentDao tournyDao;

	private static JsonUtil ju = new JsonUtil();
	private static Logger log = Logger.getLogger(TournamentController.class);
	private static ObjectMapper om = new ObjectMapper();

	@RequestMapping(value = "/tournament", method = RequestMethod.POST)
	@ResponseBody
	public String getTournamentAOP(@RequestBody int id) throws JsonProcessingException {
		Tournament t = tournyDao.loadTournament(id);
		return om.writeValueAsString(t);
	}
	
	@RequestMapping(value = "/mytournaments", method = RequestMethod.GET)
	@ResponseBody
	public String getPlayerTournamentsAOP(HttpSession session) throws JsonProcessingException {
		User u = (User) session.getAttribute("user");
		List<Tournament> t = tournyDao.loadTournamentsByPlayer(u);
		String json = ju.toJson(t);
		log.trace(json);
		return json;
	}
	
	@RequestMapping(value = "/alltournaments", method = RequestMethod.GET)
	@ResponseBody
	public String getAllTournamentsAOP() throws JsonProcessingException {
		List<Tournament> t = tournyDao.loadAllTournaments();
		String json = ju.toJson(t);
		return json;
	}

}
