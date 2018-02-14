package com.revature.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;

public class UserDaoTest {
	public static UserDao ud = new UserHibernate();
	//private static ApplicationContext ac;

	@Test
	public void test() {
		//ac = new ClassPathXmlApplicationContext("beans.xml");
		
		String username = "male";
		User u = new User(0, "mick", "ale", username, "123", "male@blah.com");

		u = ud.persistUser(u);
		assertEquals("Testing Persist: u.getId must not be 0", true, (u.getId() != 0));

		User u2 = ud.getUser(u.getId());
		assertEquals("Testing getUserbyId: u.equals(u2) must be true", true, u.equals(u2));

		User u3 = ud.getUserByUsername(username);
		assertEquals("Testing getuserByUsername: u.equals(u3) must be true", true, u.equals(u3));

		u.setLastname("BillyBob");
		ud.mergeUser(u);

		System.out.println(u2);
		u2.setLastname("BillyBob");
		System.out.println(u2);
		assertEquals("Testing merging: u2.equals(u) must be true", true, u2.equals(u));

		ud.deleteUser(u);
		u2 = ud.getUserByUsername(username);

		assertEquals("Testing deleteUser: u2 must be null", null, u2);
	}
}
