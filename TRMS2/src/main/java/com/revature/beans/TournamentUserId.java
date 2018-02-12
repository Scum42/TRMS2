package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TournamentUserId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="tournament_id")
	private int tournamentId;
	@Column(name="user_id")
	private int userId;
	
	public TournamentUserId() {
		super();
	}
	
	public TournamentUserId(int tournament_id, int user_id) {
		super();
		this.tournamentId = tournament_id;
		this.userId = user_id;
	}

	public int getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tournamentId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentUserId other = (TournamentUserId) obj;
		if (tournamentId != other.tournamentId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TournamentUserId [tournament_id=" + tournamentId + ", user_id=" + userId + "]";
	}
	
}
