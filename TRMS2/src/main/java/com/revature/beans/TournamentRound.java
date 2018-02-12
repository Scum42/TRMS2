package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tourny_to_round")
public class TournamentRound {
	@EmbeddedId
	private TournamentRoundId id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="t_id", insertable=false, updatable=false)
	private Tournament tournament;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="r_id", insertable=false, updatable=false)
	private Round round;
	
	public TournamentRound() {
		super();
	}
	
	public TournamentRound(TournamentRoundId id, Tournament tournament, Round round) {
		super();
		this.id = id;
		this.tournament = tournament;
		this.round = round;
	}

	public TournamentRoundId getId() {
		return id;
	}

	public void setId(TournamentRoundId id) {
		this.id = id;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((round == null) ? 0 : round.hashCode());
		result = prime * result + ((tournament == null) ? 0 : tournament.hashCode());
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
		TournamentRound other = (TournamentRound) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (round == null) {
			if (other.round != null)
				return false;
		} else if (!round.equals(other.round))
			return false;
		if (tournament == null) {
			if (other.tournament != null)
				return false;
		} else if (!tournament.equals(other.tournament))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TournamentRound [id=" + id + ", tournament=" + tournament + ", round=" + round + "]";
	}
	
}
