package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

@Component
public class UserHibernate implements UserDao/*, HibernateSession*/ {
	private static HibernateUtil hu = HibernateUtil.getInstance();
	private Session session;
	
	/*
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	*/
	
	// Create
	@Override
	public User persistUser(User u) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(u);

			tx.commit();
			return u;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
		
		/*
		session.save(u);
		return u;
		*/
	}

	// Read
	// Was load, trying get now.
	@Override
	public User getUser(int id) {
		
		Session su = hu.getSession();
		User u = su.get(User.class, id);
		su.close();
		return u;
		
		/*
		User u = session.get(User.class, id);
		return u;
		*/
	}

	@Override
	public User getUserByUsername(String un) {
		Session s = hu.getSession();
		String query = "FROM com.revature.beans.User WHERE username=:name";
		Query q = s.createQuery(query);
		q.setParameter("name", un);
		List<User> list = (List<User>) q.list();
		if (list.isEmpty() == false) {
			return list.get(0);
		}
		return null;
		
		/*
		String query = "FROM com.revature.beans.User WHERE username=:name";
		Query q = session.createQuery(query);
		q.setParameter("name", un);
		List<User> list = (List<User>) q.list();
		if(list.isEmpty() == false){
			return list.get(0);
		}
		return null;
		*/
	}

	// Update
	@Override
	public User mergeUser(User u) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		User user = (User) s.merge(u);
		// Wouldn't this return a proxy?
		// Will eventually try update to see what will change
		tx.commit();
		s.close();

		return user;
		
		/*
		User user = (User) session.merge(u);
		return user;
		*/
	}

	// Delete
	@Override
	public void deleteUser(User u) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(u);
		tx.commit();
		s.close();
		
		/*
		session.delete(u);
		*/
	}
}
