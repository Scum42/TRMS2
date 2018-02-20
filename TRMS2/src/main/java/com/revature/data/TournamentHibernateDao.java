package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Tournament;
import com.revature.beans.User;

@Component
public class TournamentHibernateDao implements TournamentDao, HibernateSession {

	private Logger log = Logger.getLogger(TournamentHibernateDao.class);
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void persistTournament(Tournament tournament) {
		session.save(tournament);
	}

	@Override
	public Tournament loadTournament(int id) {
		return (Tournament) session.get(Tournament.class, id);
	}

	@Override
	public List<Tournament> loadAllTournaments() {
		String hql = "From com.revature.beans.Tournament";
		return (List<Tournament>) session.createQuery(hql).list();
	}

	@Override
	public List<Tournament> loadTournamentsByOwner(User user) {
		Criteria cri = session.createCriteria(Tournament.class);
		cri.add(Restrictions.eq("ownerId", user));
		return (List<Tournament>) cri.list();
	}

	@Override
	public List<Tournament> loadTournamentsByJudge(User user) {
		Criteria cri = session.createCriteria(Tournament.class);
		cri.add(Restrictions.eq("judgeId", user));
		return (List<Tournament>) cri.list();
	}

	@Override
	public List<Tournament> loadTournamentsByPlayer(User user) {
		String hql = "From com.revature.beans.Tournament";
		List<Tournament> t = (List<Tournament>) session.createQuery(hql).list();
		log.trace(t);
		List<Tournament> myTournys = new ArrayList<>();
		for (Tournament tour : t) {
			log.trace(user);
			log.trace(tour.getRegisteredUsers());
			for (User u : tour.getRegisteredUsers()) {
				if (u.getId() == user.getId())
					myTournys.add(tour);
			}
		}
		log.trace(myTournys);
		return myTournys;
	}

	@Override
	public List<Tournament> loadOthersTournaments(User user) {
		String hql = "From com.revature.beans.Tournament Where owner !=:own";
		Query<Tournament> q = session.createQuery(hql, Tournament.class);
		q.setParameter("own", user);
		return q.getResultList();
	}

	@Override
	public void deleteTournament(Tournament tournament) {
		session.delete(tournament);
	}

	@Override
	public Tournament mergeTournament(Tournament tournament) {
		return (Tournament) session.merge(tournament);
	}

}
