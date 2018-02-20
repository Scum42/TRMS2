package com.revature.data;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.beans.Results;

@Repository
public class ResultsHibernateDao implements ResultsDao, HibernateSession {


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
		
		return null;
	}

	@Override
	public void deleteResults(Results result) {
		
		
	}

	@Override
	public Results merge(Results result) {
		
		return null;
	}

	
}
