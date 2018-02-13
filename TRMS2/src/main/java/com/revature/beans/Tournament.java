package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Tournament")
public class Tournament {
	@Id
	@Column(name = "tournament_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tournament")
	@SequenceGenerator(name = "Tournament", sequenceName = "tournyid_seq", allocationSize = 1)
	private int tournamentId;
	@Column(name = "tourny_type")
	private String tournyType;
	private String style;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private User owner;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "judge_id")
	private User judge;
	@Column(name = "min_num")
	private int minNum;
	@Column(name = "max_num")
	private int maxNum;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tourny_to_user", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> registeredUsers;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_id")
	private List<Round> tournyRounds;

	public Tournament() {
		super();
	}

	public Tournament(int tournamentId, String tournyType, String style, User owner, User judge, int minNum, int maxNum,
			List<User> registeredUsers, List<Round> tournyRounds) {
		super();
		this.tournamentId = tournamentId;
		this.tournyType = tournyType;
		this.style = style;
		this.owner = owner;
		this.judge = judge;
		this.minNum = minNum;
		this.maxNum = maxNum;
		this.registeredUsers = registeredUsers;
		this.tournyRounds = tournyRounds;
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

	public User getOwnerId() {
		return owner;
	}

	public void setOwnerId(User ownerId) {
		this.owner = ownerId;
	}

	public User getJudgeId() {
		return judge;
	}

	public void setJudgeId(User judgeId) {
		this.judge = judgeId;
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

	public List<User> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(List<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	public List<Round> getTournyRounds() {
		return tournyRounds;
	}

	public void setTournyRounds(List<Round> tournyRounds) {
		this.tournyRounds = tournyRounds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((judge == null) ? 0 : judge.hashCode());
		result = prime * result + maxNum;
		result = prime * result + minNum;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((registeredUsers == null) ? 0 : registeredUsers.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result + tournamentId;
		result = prime * result + ((tournyRounds == null) ? 0 : tournyRounds.hashCode());
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
		if (judge == null) {
			if (other.judge != null)
				return false;
		} else if (!judge.equals(other.judge))
			return false;
		if (maxNum != other.maxNum)
			return false;
		if (minNum != other.minNum)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (registeredUsers == null) {
			if (other.registeredUsers != null)
				return false;
		} else if (!registeredUsers.equals(other.registeredUsers))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (tournamentId != other.tournamentId)
			return false;
		if (tournyRounds == null) {
			if (other.tournyRounds != null)
				return false;
		} else if (!tournyRounds.equals(other.tournyRounds))
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
		return "Tournament [tournamentId=" + tournamentId + ", tournyType=" + tournyType + ", style=" + style
				+ ", ownerId=" + owner + ", judgeId=" + judge + ", minNum=" + minNum + ", maxNum=" + maxNum
				+ ", registeredUsers=" + registeredUsers + ", tournyRounds=" + tournyRounds + "]";
	}
}