package com.revature.beans;

import javax.persistence.Column;
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
	@Column(name="team_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Team")
	@SequenceGenerator(name="Team", sequenceName="team_pk_seq", allocationSize=1)
	private int teamId;
	@Column(name="team_name")
	private String teamName;
	private int captain;
	
	public Team () {
		super();
	}
	
	public Team(int team_id, String team_name, int captain) {
		super();
		this.teamId = team_id;
		this.teamName = team_name;
		this.captain = captain;
	}



	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
		result = prime * result + teamId;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
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
		if (teamId != other.teamId)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + teamId + ", team_name=" + teamName + ", captain=" + captain + "]";
	}
	
}
