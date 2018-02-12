package com.revature.data;

import java.util.Set;

import com.revature.beans.Tournament;
import com.revature.beans.User;

public class TournamentHibernate implements TournamentDao {

	@Override
	public int createTournament(Tournament tournament) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tournament getTournament(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tournament> getTournamentsByOwner(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tournament> getTournamentsByJudge(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTournament(Tournament tournament) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTournament(Tournament tournament) {
		// TODO Auto-generated method stub

	}

}
