package com.revature.data;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Tournament;
import com.revature.beans.TournamentUser;
import com.revature.beans.TournamentUserId;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class TournamentUserHibernate implements TournamentUserDao {
	private static Logger log = Logger.getLogger(TournamentUserHibernate.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int createTournamentUser(TournamentUser tu) {
		// TODO Auto-generated method stub
		// Check what this means with Nick - John
		return 0;
	}

	@Override
	public Set<TournamentUser> getTournamentUsersByTournament(Tournament t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPlayer(Tournament t, User u) {
		// TODO Auto-generated method stub
		// Notes by John: From what I can think of, this will be similar to
		// to updating the table, correct?
		
		TournamentUser tUser = new TournamentUser();
		tUser.setTournament(t);
		tUser.setUser(u);
		Session s = hu.getSession();
		Transaction tx = null;
		
		try{
			tx = s.beginTransaction();
			s.save(tUser);
			tx.commit();
		} catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {
			s.close();
		}
		
	}

	@Override
	public void removePlayer(Tournament t, User u) {
		// TODO Auto-generated method stub
		/*
		 Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(b);
		tx.commit();
		s.close();

		 * */
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		TournamentUser tUser = new TournamentUser();
		tUser.setTournament(t);
		tUser.setUser(u);
		//I need to check if this will actually delete
		tx.commit();
		s.close();
	}

	@Override
	public void deleteTournamentUser(TournamentUser tu) {
		// TODO Auto-generated method stub

	}

}
