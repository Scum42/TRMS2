package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamUserId implements Serializable {
	private static final long serialVersionUID = 2L;
	@Column(name="t_id")
	private int t_id;
	@Column(name="pid")
	private int p_id;
	
	public TeamUserId() {
		super();
	}
	
	public TeamUserId(int t_id, int p_id) {
		super();
		this.t_id = t_id;
		this.p_id = p_id;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + p_id;
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
		TeamUserId other = (TeamUserId) obj;
		if (p_id != other.p_id)
			return false;
		if (t_id != other.t_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeamUserId [t_id=" + t_id + ", p_id=" + p_id + "]";
	}
}
