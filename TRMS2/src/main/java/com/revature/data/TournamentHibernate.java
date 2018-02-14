package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Tournament;
import com.revature.beans.User;
import com.revature.util.HibernateUtilStatic;

public class TournamentHibernate implements TournamentDao, HibernateSession {
	private static Logger log = Logger.getLogger(TournamentHibernate.class);
	private static HibernateUtilStatic hu = HibernateUtilStatic.getInstance();
	private static TournamentDao td = new TournamentHibernate();
	
	@Override
	public void setSession(Session session) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// Very bad practice, but I'm too lazy to test out in jUnit right now
		User owner = new User(0, "John", "Ocon", "jocon", "123", "jocon@yahoo.com");
		// User not has id of 2 in database ...

		Tournament t = new Tournament();
		t.setTournyType("Basketball");
		t.setStyle("Bracket");
		t.setOwnerId(owner); // I don't think this is right ...
		t.setJudgeId(owner); // cause I'm lazy on doing this
		t.setMinNum(2);
		t.setMaxNum(16);

		Tournament perTourn = td.persistTournament(t);
		System.out.println("The tournament was save like: " + perTourn);

		System.exit(0); // Guarantee that the system will shut down after we are
						// done with the darn thing ...
	}

	// Create a new Tournament
	/*
	 * Notes: This will create a new Tournament and save it into the database
	 */
	@Override
	public Tournament persistTournament(Tournament tournament) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			log.warn("The tournament is: " + tournament);
			session.persist(tournament);
			log.warn("The tournament is: " + tournament);

			tx.commit();
			return tournament;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	// Read tournaments from table
	@Override
	public Tournament loadTournament(int id) {
		// TODO Auto-generated method stub
		return null;
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

	// Update the tournament
	@Override
	public void mergeTournament(Tournament tournament) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		Tournament tour = (Tournament) s.merge(tournament);
		log.info("The new tournament is: " + tour);
		tx.commit();
		s.close();
	}

	// Delete the tournament
	@Override
	public void deleteTournament(Tournament tournament) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(tournament);
		tx.commit();
		s.close();
	}
}
