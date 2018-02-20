package com.revature.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Team;
import com.revature.beans.User;
import com.revature.data.TeamDao;
import com.revature.data.UserDao;

@Service
public class TeamService {

	@Autowired
	private TeamDao teamDao;

	@Autowired
	private UserDao userDao;

	public Team createTeam(Team team) {
		return teamDao.persistTeam(team);
	}

	public Team getTeam(int id) {
		return teamDao.loadTeam(id);
	}

	public Collection<Team> getTeamsByMember(int userId) {
		User user = userDao.loadUser(userId);
		return user.getMyTeams();
	}

	public Team updateTeam(Team team) {
		return teamDao.mergeTeam(team);
	}

	public void deleteTeam(Team team) {
		teamDao.deleteTeam(team);
	}

}
