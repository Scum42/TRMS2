package com.revature.data;

import java.util.List;

import com.revature.beans.Tournament;
import com.revature.beans.User;

public interface TournamentDao {
	//CRUD
	//Create
	public Tournament persistTournament(Tournament tournament);
	
	//Read
	public Tournament loadTournament(int id);
	
	public List<Tournament> loadTournamentsByOwner(User user);
	
	public List<Tournament> loadTournamentsByJudge(User user);
	
	public List<Tournament> loadTournamentsByPlayer(User user);
	
	//Update
	public void mergeTournament(Tournament tournament);
	
	//Delete
	public void deleteTournament(Tournament tournament);
}
