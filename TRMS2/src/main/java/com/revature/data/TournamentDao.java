package com.revature.data;

import java.util.List;

import com.revature.beans.Tournament;
import com.revature.beans.User;

public interface TournamentDao {
<<<<<<< HEAD
	//CRUD
	//Create
	public Tournament persistTournament(Tournament tournament);
	
	//Read
=======

	public Tournament persistTournament(Tournament tournament);

>>>>>>> defce14ae0a388c84a8540a0025e5e89c8f9a910
	public Tournament loadTournament(int id);

	public List<Tournament> loadTournamentsByOwner(User user);

	public List<Tournament> loadTournamentsByJudge(User user);

	public List<Tournament> loadTournamentsByPlayer(User user);
<<<<<<< HEAD
	
	//Update
	public void mergeTournament(Tournament tournament);
	
	//Delete
	public void deleteTournament(Tournament tournament);
=======

	public void deleteTournament(Tournament tournament);

	public void mergeTournament(Tournament tournament);

>>>>>>> defce14ae0a388c84a8540a0025e5e89c8f9a910
}
