package com.revature.data;

import java.util.Set;

import com.revature.beans.Round;
import com.revature.beans.Tournament;
import com.revature.beans.User;

public interface TournamentRoundDao {

	public int createRound(Round r);
	
	public Round getRound(int id);
	
	public Set<Round> getRoundsByTournament(Tournament t);
	
	public Set<Round> getRoundsByPlayer(User u);
	
	public void deleteRound(Round r);
	
	public void updateRound(Round r);
}
