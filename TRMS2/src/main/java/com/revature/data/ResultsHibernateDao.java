package com.revature.data;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.beans.Results;

@Repository
public class ResultsHibernateDao implements ResultsDao, HibernateSession {

	private Logger log = Logger.getLogger(ResultsHibernateDao.class);
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public int persistResults(Results result) {
		return (Integer) session.save(result);
	}

	@Override
	public Results loadResults(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteResults(Results result) {
		// TODO Auto-generated method stub
		// Not yet implemented
	}

	@Override
	public Results merge(Results result) {
		// TODO Auto-generated method stub
		return null;
	}

}
