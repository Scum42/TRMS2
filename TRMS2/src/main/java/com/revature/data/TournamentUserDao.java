package com.revature.data;

import java.util.Set;

import com.revature.beans.Tournament;
import com.revature.beans.TournamentUser;
import com.revature.beans.User;

public interface TournamentUserDao {

	public int createTournamentUser(TournamentUser tu);
	
	public Set<TournamentUser> getTournamentUsersByTournament(Tournament t);
	
	public void addPlayer(Tournament t, User u);
	
	public void removePlayer(Tournament t, User u);
	
	public void deleteTournamentUser(TournamentUser tu);
}
