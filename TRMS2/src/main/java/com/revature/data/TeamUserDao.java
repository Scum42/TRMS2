package com.revature.data;

import java.util.Set;

import com.revature.beans.Team;
import com.revature.beans.TeamUser;
import com.revature.beans.User;

public interface TeamUserDao {
	
	public int createTeamUser(TeamUser tu);
	
	public void addMember(Team t, User u);
	
	public void removeMember(Team t, User u);
	
	public void deleteTeamUser(TeamUser tu);
	
	public Set<TeamUser> getTeamUsersByTeam(Team t);
}
