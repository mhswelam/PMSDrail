package com.revature.drail.service;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailStationsDTO;

public interface GetStationsService {
	/**
	 * 
	 * @param du
	 * @return a DrailStationsDTO if it is in the Database. If it does not exist it will return an empty DrailStationsDTO .
	 */
	public DrailStationsDTO getStations(DrailUser du);
}
