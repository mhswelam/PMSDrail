package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.repo.DrailStationRepo;

@Service
public class ViewStationServiceImpl implements ViewStationService {

	@Autowired
	DrailStationRepo repo;
	
	@Override
	public DrailStation viewStationById(int id) {
		return repo.findOne(id);
	}

}
