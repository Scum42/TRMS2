package com.revature.data;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Team;

@Component
public class TeamDaoHibernate implements HibernateSession, TeamDao {

	private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Team persistTeam(Team t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team loadTeam(int id) {
		Team team = (Team) session.get(Team.class, id);
		return team;
	}

	@Override
	public void deleteTeam(Team t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Team mergeTeam(Team t) {
		// TODO Auto-generated method stub
		return null;
	}

}
