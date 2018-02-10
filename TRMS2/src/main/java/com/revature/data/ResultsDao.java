package com.revature.data;

import com.revature.beans.Results;

public interface ResultsDao {

	/*
	 * Inserts Results object in database
	 * 
	 * input: result -- Result object to be inserted
	 * return: id of created Results
	 */
	public int createResults(Results result);
	
	/*
	 * returns Results object from database
	 * 
	 * input: id -- identifier of Results object to get
	 * return: Results object that matches id, else null
	 */
	public Results getResults(int id);
	
	/*
	 * deletes Results object from dataabse
	 * 
	 * input: result -- Results object to delete
	 *  
	 */
	public void deleteResults(Results result);
	
	/*
	 * updates Results object in database
	 * 
	 * input: result -- Results object to be updated
	 */
	public void updateResults(Results result);
}
