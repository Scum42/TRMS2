package com.revature.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.beans.User;

public class UserDaoTest {
	public static UserDao ud = new UserHibernate();

	@Test
	public void test() {
		User u = new User(0, "John", "Ocon", "jocon", "123");
		u.setEmail("jocon@blah.com");

		u = ud.persistUser(u);
		assertEquals("Testing Persist: u.getId must not be 0", true, (u.getId() != 0));

		User u2 = ud.getUser(u.getId());
		assertEquals("Testing getUserbyId: u.equals(u2) must be true", true, u.equals(u2));

		User u3 = ud.getUserByUsername("jocon");
		assertEquals("Testing getuserByUsername: u.equals(u3) must be true", true, u.equals(u3));

		u.setLastname("BillyBob");
		ud.mergeUser(u);

		System.out.println(u2);
		u2.setLastname("BillyBob");
		System.out.println(u2);
		assertEquals("Testing merging: u2.equals(u) must be true", true, u2.equals(u));

		ud.deleteUser(u);
		u2 = ud.getUserByUsername("jocon");

		assertEquals("Testing deleteUser: u2 must be null", null, u2);
	}
}
