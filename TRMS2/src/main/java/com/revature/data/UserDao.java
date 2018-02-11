package com.revature.data;

import java.util.Set;

import com.revature.beans.Team;
import com.revature.beans.Tournament;
import com.revature.beans.User;

public interface UserDao {

	public int createUser(User u);
	
	public User getUser(int id);
	
	public User getUserByUsername(String un);
	
	public void updateUser(User u);
	
	public void deleteUser(User u);
}