package com.revature.data;

import com.revature.beans.Team;

public interface TeamDao {

	public Team persistTeam(Team t);

	public Team loadTeam(int id);

	public void deleteTeam(Team t);

	public Team mergeTeam(Team t);

}
