package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Round")
public class Round {
	@Id
	@Column(name="round_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Round")
	@SequenceGenerator(name="Round", sequenceName="rounds_seq", allocationSize=1)
	private int roundId;
	@Column(name="round_num")
	private int roundNum;
	private int player1;
	private int player2;
	private int r_result;
	
	public Round() {
		super();
	}
	
	public Round(int round_id, int round_num, int player1, int player2, int r_result) {
		super();
		this.roundId = round_id;
		this.roundNum = round_num;
		this.player1 = player1;
		this.player2 = player2;
		this.r_result = r_result;
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

	public int getPlayer1() {
		return player1;
	}

	public void setPlayer1(int player1) {
		this.player1 = player1;
	}

	public int getPlayer2() {
		return player2;
	}

	public void setPlayer2(int player2) {
		this.player2 = player2;
	}

	public int getR_result() {
		return r_result;
	}

	public void setR_result(int r_result) {
		this.r_result = r_result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + player1;
		result = prime * result + player2;
		result = prime * result + r_result;
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
		if (player1 != other.player1)
			return false;
		if (player2 != other.player2)
			return false;
		if (r_result != other.r_result)
			return false;
		if (roundId != other.roundId)
			return false;
		if (roundNum != other.roundNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Round [round_id=" + roundId + ", round_num=" + roundNum + ", player1=" + player1 + ", player2="
				+ player2 + ", r_result=" + r_result + "]";
	}
	
}
