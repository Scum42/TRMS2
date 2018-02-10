package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tourny_to_user")
//Not sure what should actually go in the ignore properties
//@JsonIgnoreProperties(value={"participant_id", "tourny_id"})
public class TournamentUser {
	@EmbeddedId
	private TournamentUserId id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tourny_id", insertable=false, updatable=false)
	private Tournament tournament;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="participant_id")
	private User user;
	
	public TournamentUser() {
		super();
	}
	
	public TournamentUser(TournamentUserId id, Tournament tournament, User user) {
		super();
		this.id = id;
		this.tournament = tournament;
		this.user = user;
	}

	public TournamentUserId getId() {
		return id;
	}

	public void setId(TournamentUserId id) {
		this.id = id;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
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
		result = prime * result + ((tournament == null) ? 0 : tournament.hashCode());
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
		TournamentUser other = (TournamentUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tournament == null) {
			if (other.tournament != null)
				return false;
		} else if (!tournament.equals(other.tournament))
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
		return "TournamentUser [id=" + id + ", tournament=" + tournament + ", user=" + user + "]";
	}
	
	
}