package com.revature.drail.service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailURS;
import com.revature.drail.beans.DrailUser;

public interface GetURSService {

	public DrailURS getStationURS(DrailUser user,DrailStation station);
	
}
