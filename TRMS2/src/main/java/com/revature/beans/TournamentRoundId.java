package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TournamentRoundId {
	private static final long serivalVersionUID = 3L;
	@Column(name="t_id")
	private int t_id;
	@Column(name="r_id")
	private int r_id;
	
	public TournamentRoundId() {
		super();
	}
	
	public TournamentRoundId(int t_id, int r_id) {
		this.r_id = r_id;
		this.t_id = t_id;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + r_id;
		result = prime * result + t_id;
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
		if (r_id != other.r_id)
			return false;
		if (t_id != other.t_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TournamentRoundId [t_id=" + t_id + ", r_id=" + r_id + "]";
	}
	
}
