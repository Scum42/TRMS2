package com.revature.data;

import com.revature.beans.Team;

public interface TeamDao {
	
	public int createTeam(Team t);
	
	public Team getTeam(int id);
	
	public void deleteTeam(Team t);
	
	public void updateTeam(Team t);

}
