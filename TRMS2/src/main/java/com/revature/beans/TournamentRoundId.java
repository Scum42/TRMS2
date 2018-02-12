package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TournamentRoundId implements Serializable {
	private static final long serivalVersionUID = 3L;
	@Column(name="t_id")
	private int tId;
	@Column(name="r_id")
	private int rId;
	
	public TournamentRoundId() {
		super();
	}
	
	public TournamentRoundId(int t_id, int r_id) {
		this.rId = r_id;
		this.tId = t_id;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rId;
		result = prime * result + tId;
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
		TournamentRoundId other = (TournamentRoundId) obj;
		if (rId != other.rId)
			return false;
		if (tId != other.tId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TournamentRoundId [t_id=" + tId + ", r_id=" + rId + "]";
	}
	
}
