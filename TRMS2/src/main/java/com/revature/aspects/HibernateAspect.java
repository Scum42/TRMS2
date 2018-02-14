//package com.revature.aspects;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.revature.data.HibernateSession;
//import com.revature.util.HibernateUtil;
//
//@Component
//@Aspect
//public class HibernateAspect {
//
//	@Autowired
//	private HibernateUtil hu;
//
//	/* Hooks */
//	@Pointcut("execution(* com.revature.data..*(..)) && !execution(* com.revature.data..setSession(..))")
//	public void allDaoObjections() {
//		/* Hook for all DAO methods except for HibernateSession#setSession(Session) */
//	}
//
//	@Around("allDaoObjections()")
//	public Object manageSession(ProceedingJoinPoint pjp) throws Throwable {
//		Object pjpReturn = null;
//
//		Session session = hu.getSession();
//		Transaction txn = session.beginTransaction();
//
//		HibernateSession hs = (HibernateSession) pjp.getThis();
//		hs.setSession(session);
//
//		try {
//			pjpReturn = pjp.proceed();
//		} catch (Throwable e) {
//			txn.rollback();
//			throw e;
//		}
//
//		txn.commit();
//		session.close();
//		hs.setSession(null);
//
//		return pjpReturn;
//	}
//
//}
