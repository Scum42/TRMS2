package com.revature.data;

import java.util.List;

import com.revature.beans.Round;
import com.revature.beans.Tournament;
import com.revature.beans.User;

public interface RoundDao {

	public Round persistRound(Round round);

	public Round loadRound(int id);

	public List<Round> loadRoundsByTournament(int id);

	public List<Round> loadRoundsByPlayer(User user);

	public void deleteRound(Round round);

	public Round mergeRound(Round round);

}
