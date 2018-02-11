package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Team")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Team")
	@SequenceGenerator(name="Team", sequenceName="team_pk_seq", allocationSize=1)
	private int team_id;
	private String team_name;
	private int captain;
	
	public Team () {
		super();
	}
	
	public Team(int team_id, String team_name, int captain) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.captain = captain;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public int getCaptain() {
		return captain;
	}

	public void setCaptain(int captain) {
		this.captain = captain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + captain;
		result = prime * result + team_id;
		result = prime * result + ((team_name == null) ? 0 : team_name.hashCode());
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
		Team other = (Team) obj;
		if (captain != other.captain)
			return false;
		if (team_id != other.team_id)
			return false;
		if (team_name == null) {
			if (other.team_name != null)
				return false;
		} else if (!team_name.equals(other.team_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", captain=" + captain + "]";
	}
	
}
