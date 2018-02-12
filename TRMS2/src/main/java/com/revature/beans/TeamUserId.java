package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamUserId implements Serializable {
	private static final long serialVersionUID = 2L;
	@Column(name="t_id")
	private int teamId;
	@Column(name="p_id")
	private int playerId;
	
	public TeamUserId() {
		super();
	}
	
	public TeamUserId(int t_id, int p_id) {
		super();
		this.teamId = t_id;
		this.playerId = p_id;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + playerId;
		result = prime * result + teamId;
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
		TeamUserId other = (TeamUserId) obj;
		if (playerId != other.playerId)
			return false;
		if (teamId != other.teamId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeamUserId [t_id=" + teamId + ", p_id=" + playerId + "]";
	}
}
