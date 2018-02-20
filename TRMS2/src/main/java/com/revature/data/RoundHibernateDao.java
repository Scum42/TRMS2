package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Round;
import com.revature.beans.Tournament;
import com.revature.beans.User;

@Repository
public class RoundHibernateDao implements RoundDao, HibernateSession {

	private Logger log = Logger.getLogger(RoundHibernateDao.class);
	private Session session;
	
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Round persistRound(Round round) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Round loadRound(int id) {
		return (Round) session.get(Round.class, id);
	}

	@Override
	public List<Round> loadRoundsByTournament(int id) {
		String hql = "From com.revature.beans.Tournament Where tournamentId =:id";
		Query<Tournament> q = session.createQuery(hql, Tournament.class);
		q.setParameter("id", id);
		Tournament t = q.getSingleResult();
		List<Round> r = t.getTournyRounds();
		return r;
	}

	@Override
	public List<Round> loadRoundsByPlayer(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRound(Round round) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Round mergeRound(Round round) {
		// TODO Auto-generated method stub
		return null;
	}

}
