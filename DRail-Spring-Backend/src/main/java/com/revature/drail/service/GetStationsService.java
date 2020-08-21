package com.revature.drail.service;


import java.util.List;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;

public interface GetStationsService {

	public List<DrailStation> getStations(DrailUser du);

}
