package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TournamentUserId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="tournament_id")
	private int tournament_id;
	@Column(name="user_id")
	private int user_id;
	
	public TournamentUserId() {
		super();
	}
	
	public TournamentUserId(int tournament_id, int user_id) {
		super();
		this.tournament_id = tournament_id;
		this.user_id = user_id;
	}

	public int getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(int tournament_id) {
		this.tournament_id = tournament_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tournament_id;
		result = prime * result + user_id;
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
		if (tournament_id != other.tournament_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TournamentUserId [tournament_id=" + tournament_id + ", user_id=" + user_id + "]";
	}
	
}
