package com.revature.data;

import com.revature.beans.User;

public interface UserDao {

	public User persistUser(User u);

	public User getUser(int id);

	public User getUserByUsername(String un);

	public User mergeUser(User u);

	public void deleteUser(User u);

}