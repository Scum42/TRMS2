package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Team;
import com.revature.data.TeamDao;

@Service
public class TeamService {

	@Autowired
	private TeamDao teamDao;
	
	public Team createTeam(Team team) {
		return teamDao.persistTeam(team);
	}

	public Team getTeam(int id) {
		return teamDao.loadTeam(id);
	}
	
	public Team updateTeam(Team team) {
		return teamDao.mergeTeam(team);
	}

	public void deleteTeam(Team team) {
		teamDao.deleteTeam(team);
	}

}
