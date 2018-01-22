package com.revature.drail.service;

import com.revature.drail.beans.DrailRail;



/**
 * @author Mohamed
 * 
 * To Get the Rail 
 *
 */
public interface GetRailService {
	
	
	/**
	 * To get a rail info  with its id
	 * @param railId will take to rail id
	 * @return will return drailrail 
	 */
	public DrailRail getRail(int railId);

}
