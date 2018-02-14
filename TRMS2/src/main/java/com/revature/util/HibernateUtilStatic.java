package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilStatic {
	private SessionFactory sessionFactory;

	private HibernateUtilStatic() {
		super();
	}

	private static HibernateUtilStatic instance = null;

	public static HibernateUtilStatic getInstance() {
		if (instance == null)
			instance = new HibernateUtilStatic();
		return instance;
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
			Metadata meta = new MetadataSources(standardRegistry).getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
			sessionFactory = meta.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = null;
	}

	public Session getSession() {
		return this.getSessionFactory().openSession();
	}
}
