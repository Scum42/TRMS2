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
	
	@Autowired
	JsonUtil ju;

	private static Logger log = Logger.getLogger(TournamentController.class);
	private static ObjectMapper om = new ObjectMapper();

	@RequestMapping(value = "/tournament", method = RequestMethod.POST)
	@ResponseBody
	public String getTournamentAOP(@RequestBody int id) throws JsonProcessingException {
		Tournament t = tournyDao.loadTournament(id);
		return ju.toJson(t);
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

	@RequestMapping(value = "/ownertournaments", method = RequestMethod.GET)
	@ResponseBody
	public String getOwnerTournamentsAOP(HttpSession session) throws JsonProcessingException {
		User u = (User) session.getAttribute("user");
		log.trace("\n\n\n\tOwner is: " + u);
		List<Tournament> t = tournyDao.loadTournamentsByOwner(u);
		String json = ju.toJson(t);
		log.trace(json);
		return json;
	}

	@RequestMapping(value = "/judgetournaments", method = RequestMethod.GET)
	@ResponseBody
	public String getJudgeTournamentsAOP(HttpSession session) throws JsonProcessingException {
		User u = (User) session.getAttribute("user");
		List<Tournament> t = tournyDao.loadTournamentsByJudge(u);
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
	
	@RequestMapping(value = "/allOtherTournaments", method = RequestMethod.GET)
	@ResponseBody
	public String getAllOtherTournamentsAOP(HttpSession session) throws JsonProcessingException {
		List<Tournament> othersTournaments = tournyDao.loadOthersTournaments((User) session.getAttribute("user"));
		String json = ju.toJson(othersTournaments);
		log.trace(json);
		return json;
	}
	
	@RequestMapping(value = "/joinTournament", method = RequestMethod.POST)
	@ResponseBody
	public String joinTournamentAOP(@RequestBody Tournament tournament, HttpSession session) throws JsonProcessingException {
		if(tournament == null){
			log.trace("\n\nTournament was empty in joinTournament");
			return JsonUtil.JSON_NULL;
		}else{
			List<User> tRegUsers = tournament.getRegisteredUsers();
			User signedUser = (User) session.getAttribute("user");
			if(tRegUsers.contains(signedUser) == false && tRegUsers.size() + 1 < tournament.getMaxNum()){
				tRegUsers.add(signedUser);
				tournament.setRegisteredUsers(tRegUsers);
				log.trace("User wasn't in the registered list. Adding ...");
				Tournament updated = tournyDao.mergeTournament(tournament);
				return ju.toJson(updated);
			} else {
				log.trace("User was already in the tournament or the tournament was full!");
				return JsonUtil.JSON_NULL;
			}
		}
	}
	
	@RequestMapping(value = "/dropUserFromTournament", method = RequestMethod.POST)
	@ResponseBody
	public String dropUserFromTournamentAOP(@RequestBody User drop, HttpSession session) throws JsonProcessingException {
		Tournament tournament = (Tournament) session.getAttribute("tournamentReject");
		if(tournament == null){
			return JsonUtil.JSON_NULL;
		}
		if(tournament.getTournyRounds() != null || !tournament.getTournyRounds().isEmpty()){
			log.trace("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			log.trace("Tournament has already started!");
			log.trace("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			return JsonUtil.JSON_NULL;
		}else{
			List<User> tRegUsers = tournament.getRegisteredUsers();
			tRegUsers.remove(drop);
			tournament.setRegisteredUsers(tRegUsers);
			Tournament updated = tournyDao.mergeTournament(tournament);
			return ju.toJson(updated);
		}
	}
	
	@RequestMapping(value = "/selectTournamentForReject", method = RequestMethod.POST)
	@ResponseBody
	public String selectingTournament(@RequestBody Tournament tourn, HttpSession session) throws JsonProcessingException{
		if(session.getAttribute("user") != null){
			session.setAttribute("tournamentReject", tourn);
			return ju.toJson(tourn);
		}else{
			return JsonUtil.JSON_NULL;
		}
	}
}
