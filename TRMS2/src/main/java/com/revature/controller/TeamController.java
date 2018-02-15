package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Team;
import com.revature.services.TeamService;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "http://18.216.71.226:4200" })
public class TeamController {

	@Autowired
	private TeamService teamService;

	private static ObjectMapper om = new ObjectMapper();

	/*
	 * Test for all CRUD operations in TeamDaoHibernate/TeamService. Constructs a
	 * new Team, persists the Team to the database, fetches the Team back from the
	 * database, updates the Team's name, and then deletes the Team from the
	 * database.
	 */
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	@ResponseBody
	public String getTeam() throws JsonProcessingException {
		String response = "";

		// Team team = new Team(0, "ChannelFireball Ice");
		Team team = new Team();
		team.setTeamName("ChannelFireball Ice");
		response += "Our new team: " + om.writeValueAsString(team) + "\n";

		team = teamService.createTeam(team);
		response += "Created team: " + om.writeValueAsString(team) + "\n";

		team = teamService.getTeam(team.getTeamId());
		response += "Fetched team: " + om.writeValueAsString(team) + "\n";

		team.setTeamName("ChannelFireball Fire");
		team = teamService.updateTeam(team);
		response += "Updated team: " + om.writeValueAsString(team) + "\n";

		teamService.deleteTeam(team);
		team = teamService.getTeam(team.getTeamId());
		response += "Deleted team: " + om.writeValueAsString(team) + "\n";

		return response;
	}

}
