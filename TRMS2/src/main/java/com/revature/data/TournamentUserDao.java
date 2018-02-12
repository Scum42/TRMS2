package com.revature.data;

import java.util.Set;

import com.revature.beans.Tournament;
import com.revature.beans.TournamentUser;
import com.revature.beans.User;

//These may need to be changed to accommodate hibernate
public interface TournamentUserDao {

	public TournamentUser persistTournamentUser(TournamentUser tu);
	
	public Set<TournamentUser> getTournamentUsersByTournament(Tournament t);
	
	// These next two may not be needed.
	public void addPlayer(Tournament t, User u);
	
	public void removePlayer(Tournament t, User u);
	
	public void deleteTournamentUser(TournamentUser tu);
}
