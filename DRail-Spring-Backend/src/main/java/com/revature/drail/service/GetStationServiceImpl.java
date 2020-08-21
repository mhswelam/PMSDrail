package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.repo.DrailRailRepo;
import com.revature.drail.repo.DrailStationRepo;

@Service
public class GetStationServiceImpl implements GetStationService {
	
	@Autowired
	DrailStationRepo stationRepo;
	
	@Autowired
	DrailRailRepo railRepo;

	@Override
	public DrailStation getStationByRail(int railId) {
		DrailRail rail = railRepo.getOne(railId);
		return rail.getStation();
	}

}
