package com.revature.drail.service;

import com.revature.drail.beans.DrailStation;

public interface ViewStationService {
	/**
	 * 
	 * @param id
	 * @return DrailStation with macthing id. if it does not exsit it will return null.
	 */
	public DrailStation viewStationById(int id);
}
