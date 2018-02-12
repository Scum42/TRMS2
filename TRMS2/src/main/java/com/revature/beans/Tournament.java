package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Tournament")
public class Tournament {
	@Id
	@Column(name="tournament_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Tournament")
	@SequenceGenerator(name="Tournament", sequenceName="tournyid_seq", allocationSize=1)
	private int tournamentId;
	@Column(name="tourny_type")
	private String tournyType;
	private String style;
	@Column(name="owner_id")
	private int ownerId;
	@Column(name="judge_id")
	private int judgeId;
	@Column(name="min_num")
	private int minNum;
	@Column(name="max_num")
	private int maxNum;
	
	public Tournament() {
		super();
	}
	
	public Tournament(int tournament_id, String tourny_type, String style, int owner_id, int judge_id, int min_num, int max_num) {
		super();
		this.tournamentId = tournament_id;
		this.tournyType = tourny_type;
		this.style = style;
		this.ownerId = owner_id;
		this.judgeId = judge_id;
		this.minNum = min_num;
		this.maxNum = max_num;
	}

	public int getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournyType() {
		return tournyType;
	}

	public void setTournyType(String tournyType) {
		this.tournyType = tournyType;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}

	public int getMinNum() {
		return minNum;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + judgeId;
		result = prime * result + maxNum;
		result = prime * result + minNum;
		result = prime * result + ownerId;
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result + tournamentId;
		result = prime * result + ((tournyType == null) ? 0 : tournyType.hashCode());
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
		Tournament other = (Tournament) obj;
		if (judgeId != other.judgeId)
			return false;
		if (maxNum != other.maxNum)
			return false;
		if (minNum != other.minNum)
			return false;
		if (ownerId != other.ownerId)
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (tournamentId != other.tournamentId)
			return false;
		if (tournyType == null) {
			if (other.tournyType != null)
				return false;
		} else if (!tournyType.equals(other.tournyType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tournament [tournament_id=" + tournamentId + ", tourny_type=" + tournyType + ", style=" + style
				+ ", owner_id=" + ownerId + ", judge_id=" + judgeId + ", min_num=" + minNum + ", max_num=" + maxNum
				+ "]";
	}
}