package com.revature.drail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.repo.DrailStationRepo;

@Service
public class GetStationsServiceImpl implements GetStationsService {

	@Autowired
	DrailStationRepo repo;
	
	@Override
	public List<DrailStation> getStations(DrailUser du){
		return repo.findAll();
	};
}



