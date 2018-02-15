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
		int id = (int) session.save(t);
		return loadTeam(id);
	}

	@Override
	public Team loadTeam(int id) {
		Team team = session.get(Team.class, id);
		return team;
	}

	@Override
	public void deleteTeam(Team t) {
		session.delete(t);
	}

	@Override
	public Team mergeTeam(Team t) {
		session.update(t);
		return loadTeam(t.getTeamId());
	}

}
