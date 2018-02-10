package com.revature.data;

import java.util.Set;

import com.revature.beans.Round;
import com.revature.beans.Tournament;
import com.revature.beans.User;

public interface RoundDao {
	
	public int createRound(Round round);
	
	public Round getRound(int id);
	
	public Set<Round> getRoundsByTournament(Tournament tournament);
	
	public Set<Round> getRoundsByPlayer(User user);
	
	public void deleteRound(Round round);
	
	public void updateRound(Round round);
}
