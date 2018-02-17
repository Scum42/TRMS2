package com.revature.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	UserDao dao;

	@Before
	public void before() {
		dao = new UserHibernateDao();
	}

	@Test
	public void autowireTest() {
		Assert.assertNotNull(dao);
	}
}
