package com.revature.data;

import java.util.Set;

import com.revature.beans.Tournament;
import com.revature.beans.User;

public interface TournamentDao {
	
	public int createTournament(Tournament tournament);
	
	public Tournament getTournament(int id);
	
	public Set<Tournament> getTournamentsByOwner(User user);
	
	public Set<Tournament> getTournamentsByJudge(User user);
	
	public void deleteTournament(Tournament tournament);
	
	public void updateTournament(Tournament tournament);
}
