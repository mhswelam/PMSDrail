package com.revature.drail.service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailStationDTO;

public interface AddStationService {

	public DrailStationDTO addStation(DrailUser du, DrailStation ds);
	
}
