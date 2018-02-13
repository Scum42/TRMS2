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

@Entity
@Table(name = "Round")
public class Round {
	@Id
	@Column(name = "round_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Round")
	@SequenceGenerator(name = "Round", sequenceName = "rounds_seq", allocationSize = 1)
	private int roundId;
	@Column(name = "round_num")
	private int roundNum;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player1")
	private User player1;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player2")
	private User player2;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "result_id")
	private Results roundResult;

	public Round() {
		super();
	}

	public Round(int roundId, int roundNum, User player1, User player2, Results roundResult) {
		super();
		this.roundId = roundId;
		this.roundNum = roundNum;
		this.player1 = player1;
		this.player2 = player2;
		this.roundResult = roundResult;
	}

	public int getRoundId() {
		return roundId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	public int getRoundNum() {
		return roundNum;
	}

	public void setRoundNum(int roundNum) {
		this.roundNum = roundNum;
	}

	public User getPlayer1() {
		return player1;
	}

	public void setPlayer1(User player1) {
		this.player1 = player1;
	}

	public User getPlayer2() {
		return player2;
	}

	public void setPlayer2(User player2) {
		this.player2 = player2;
	}

	public Results getRoundResult() {
		return roundResult;
	}

	public void setRoundResult(Results roundResult) {
		this.roundResult = roundResult;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player1 == null) ? 0 : player1.hashCode());
		result = prime * result + ((player2 == null) ? 0 : player2.hashCode());
		result = prime * result + ((roundResult == null) ? 0 : roundResult.hashCode());
		result = prime * result + roundId;
		result = prime * result + roundNum;
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
		Round other = (Round) obj;
		if (player1 == null) {
			if (other.player1 != null)
				return false;
		} else if (!player1.equals(other.player1))
			return false;
		if (player2 == null) {
			if (other.player2 != null)
				return false;
		} else if (!player2.equals(other.player2))
			return false;
		if (roundResult == null) {
			if (other.roundResult != null)
				return false;
		} else if (!roundResult.equals(other.roundResult))
			return false;
		if (roundId != other.roundId)
			return false;
		if (roundNum != other.roundNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Round [roundId=" + roundId + ", roundNum=" + roundNum + ", player1=" + player1 + ", player2=" + player2
				+ ", roundResult=" + roundResult + "]";
	}

}
