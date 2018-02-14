package com.revature.data;

import org.hibernate.Session;

/**
 * All Hibernate implementations of DAOs should implement this interface for
 * automatic session management using HibernateAspect.
 */
public interface HibernateSession {

	/**
	 * A setter method for HibernateAspect to provide a session for the implementing
	 * DAO. The DAO should include a private Session field that is set by this
	 * method.
	 * 
	 * @param session
	 *            a Hibernate Session object, provided by HibernateAspect
	 */
	public void setSession(Session session);

}
