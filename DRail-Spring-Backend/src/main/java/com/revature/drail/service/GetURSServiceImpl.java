package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailURS;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.repo.DRailURSRepo;

@Service
public class GetURSServiceImpl implements GetURSService {

	@Autowired
	DRailURSRepo repo;
	
	@Override
	public DrailURS getStationURS(DrailUser user,DrailStation station) {
		return repo.findByUserInAndStationIn(user, station);
	}
	
}
