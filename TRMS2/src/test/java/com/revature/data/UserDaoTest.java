package com.revature.data;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoTest {
	@Autowired
	UserDao dao;

	@Test
	public void autowireTest() {
		Assert.assertNotNull(dao);
	}
}
