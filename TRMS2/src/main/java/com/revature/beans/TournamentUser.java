package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//User needs to be uncommented once it is created
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
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="participant_id")
//	private User user;
//	
	public TournamentUser() {
		super();
	}
	
	public TournamentUser(TournamentUserId id, Tournament tournament) { //User user) {
		super();
		this.id = id;
		this.tournament = tournament;
		//this.user = user;
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

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	//to do --- Generate hashcode and equals
}