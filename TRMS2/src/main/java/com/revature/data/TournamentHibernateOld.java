package com.revature.data;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Tournament;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

/*	Notes By Jonathan
 *	So, since we need the Hibernate Implementations of this, and I need to get started on my part of the project
 *	I'm adding an implementation of Hibernate for Tournament
 *	If you have any else to add, or edit, please do so.
 *	I just ask that you put a note next to the method you are changing and the reasoning
 *	either somewhere here, or on Discord.
 *
 *	That said, I'm going to be implementating some testcases for this.	
 */

public class TournamentHibernateOld /*implements TournamentDao*/ {
	private static Logger log = Logger.getLogger(TournamentHibernateOld.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();
	
	//@Override
	public int createTournament(Tournament tournament) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public Tournament getTournament(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Set<Tournament> getTournamentsByOwner(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Set<Tournament> getTournamentsByJudge(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public void deleteTournament(Tournament tournament) {
		Session s = hu.getSession();
		Transaction tx = s.getTransaction();
		s.delete(tournament);
		tx.commit();
		s.close();
	}

	//@Override
	public void updateTournament(Tournament tournament) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		Tournament tour = (Tournament) s.merge(tournament);
		log.info("The new tournament is: " + tour);
		tx.commit();
		s.close();
	}
}
