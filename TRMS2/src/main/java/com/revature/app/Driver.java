package com.revature.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;

public class Driver {
	public static UserDao ud = new UserHibernate();
	private static ApplicationContext ac;
	
	public static void main(String[] args){
		ac = new ClassPathXmlApplicationContext("beans.xml");
		
		User u = new User(0, "Jack", "Son", "json", "123", "json@blah.com");

		u = ud.persistUser(u);
		System.out.println("User is: " + u);
	}
}
