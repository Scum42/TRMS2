package com.revature.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public class UserHibernateDao implements UserDao, HibernateSession {
	private Session session;

	@Override
	public int persistUser(User u) {
		return (Integer) session.save(u);
	}

	@Override
	public User loadUser(int id) {
		return (User) session.get(User.class, id);
	}

	@Override
	public User loadUserByUsername(String un) {
		Criteria cri = session.createCriteria(User.class);
		cri.add(Restrictions.eq("username", un));
		return (User) cri.uniqueResult();
	}

	@Override
	public User loadUserByUsernameAndPassword(String username, String password) {
		Criteria cri = session.createCriteria(User.class);
		cri.add(Restrictions.eq("username", username));
		cri.add(Restrictions.eq("password", password));
		return (User) cri.uniqueResult();
	}

	@Override
	public User mergeUser(User u) {
		return (User) session.merge(u);
	}

	@Override
	public void deleteUser(User u) {
		session.delete(u);
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

}
