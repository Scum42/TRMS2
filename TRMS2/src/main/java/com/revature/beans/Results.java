package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Results")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Results {
	@Id
	@Column(name = "result_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "results")
	@SequenceGenerator(name = "results", sequenceName = "result_pk_seq", allocationSize = 1)
	private int resultId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "win")
	private User winner;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loss")
	private User loser;

	public Results() {
		super();
	}

	public Results(int resultId, User winner, User loser) {
		super();
		this.resultId = resultId;
		this.winner = winner;
		this.loser = loser;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public User getWinner() {
		return winner;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}

	public User getLoser() {
		return loser;
	}

	public void setLoser(User loser) {
		this.loser = loser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loser == null) ? 0 : loser.hashCode());
		result = prime * result + resultId;
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
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
		Results other = (Results) obj;
		if (loser == null) {
			if (other.loser != null)
				return false;
		} else if (!loser.equals(other.loser))
			return false;
		if (resultId != other.resultId)
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Results [resultId=" + resultId + ", winner=" + winner + ", loser=" + loser + "]";
	}
}
