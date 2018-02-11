package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="team_to_user")
public class TeamUser {
	@EmbeddedId
	private TeamUserId id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="t_id", insertable=false, updatable=false)
	private Team team;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="p_id", insertable=false, updatable=false)
	private User user;
	
	public TeamUser() {
		super();
	}
	
	public TeamUser(TeamUserId id, Team team, User user) {
		super();
		this.id = id;
		this.team = team;
		this.user = user;
	}

	public TeamUserId getId() {
		return id;
	}

	public void setId(TeamUserId id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		TeamUser other = (TeamUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeamUser [id=" + id + ", team=" + team + ", user=" + user + "]";
	}
	
}
