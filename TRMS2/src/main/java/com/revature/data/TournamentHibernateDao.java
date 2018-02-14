package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Tournament;
import com.revature.beans.User;

@Component
public class TournamentHibernateDao implements TournamentDao, HibernateSession {
	private static Logger log = Logger.getLogger(TournamentHibernateDao.class);
	private Session session;

	@Override
	public Tournament persistTournament(Tournament tournament) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tournament loadTournament(int id) {
		log.trace("Session is: " + session);
		Tournament t = (Tournament) session.get(Tournament.class, id);
		log.trace(t.getStyle());
		return (Tournament) session.get(Tournament.class, id);
	}

	@Override
	public List<Tournament> loadTournamentsByOwner(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tournament> loadTournamentsByJudge(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tournament> loadTournamentsByPlayer(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTournament(Tournament tournament) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mergeTournament(Tournament tournament) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSession(Session session) {
		log.trace("Setting session to: " + session);
		this.session = session;
	}

}
