package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.repo.DrailStationRepo;

@Service
public class AddStationServiceImpl implements AddStationService {

	@Autowired
	DrailStationRepo repo;
	
	@Override
	public DrailStation addStation(DrailUser du, DrailStation ds) {
//		ds.getUsers().put(du.getUserId(), du);
		ds.getUsers().add(du);
		return repo.save(ds);
	}

}
