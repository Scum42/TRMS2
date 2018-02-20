package com.revature.data;

import com.revature.beans.User;

public interface UserDao {

	public void persistUser(User u);

	public User loadUser(int id);

	public User loadUserByUsername(String un);

	public User loadUserByUsernameAndPassword(String username, String password);

	public User mergeUser(User u);

	public void deleteUser(User u);

}