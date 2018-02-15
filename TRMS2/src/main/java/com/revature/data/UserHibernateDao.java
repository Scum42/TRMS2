package com.revature.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Component
public class UserHibernateDao implements UserDao, HibernateSession {
	private Session session;

	@Override
	public User persistUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadUser(int id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

}
