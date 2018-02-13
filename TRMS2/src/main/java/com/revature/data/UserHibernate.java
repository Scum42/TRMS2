package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserHibernate implements UserDao {
	private static Logger log = Logger.getLogger(UserHibernate.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();

	// Create
	@Override
	public User persistUser(User u) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = (Integer) session.save(u);

			tx.commit();
			return u;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	// Read
	// Was load, trying get now.
	@Override
	public User getUser(int id) {
		Session su = hu.getSession();
		User u = su.get(User.class, id);
		su.close();
		return u;
	}

	@Override
	public User getUserByUsername(String un) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		String query = "FROM com.revature.beans.User WHERE username=:name";
		Query q = s.createQuery(query);
		q.setParameter("name", un);
		List<User> list = (List<User>) q.list();
		if (list.isEmpty() == false) {
			return list.get(0);
		}
		return null;
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
	}

	// Delete
	@Override
	public void deleteUser(User u) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(u);
		tx.commit();
		s.close();
	}
}
