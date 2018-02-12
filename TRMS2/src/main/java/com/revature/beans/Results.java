package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Results")
public class Results {
	@Id
	@Column(name="result_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="results")
	@SequenceGenerator(name="results", sequenceName="result_pk_seq", allocationSize=1)
	private int resultId;
	private int win;
	private int loss;
	
	public Results() {
		super();
	}
	
	public Results(int result_id, int win, int loss) {
		super();
		this.resultId = result_id;
		this.win = win;
		this.loss = loss;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int result_id) {
		this.resultId = result_id;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loss;
		result = prime * result + resultId;
		result = prime * result + win;
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
		if (loss != other.loss)
			return false;
		if (resultId != other.resultId)
			return false;
		if (win != other.win)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Results [result_id=" + resultId + ", win=" + win + ", loss=" + loss + "]";
	}
	
}
