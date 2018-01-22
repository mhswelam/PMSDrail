package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.repo.DrailRailRepo;



@Service
public class AddRailServiceImp implements AddRailService {
	
	@Autowired
	DrailRailRepo repo;
	

	@Override
	public DrailRail addRail(int stid, String railName, int railOrder) {
		DrailStation st = new DrailStation();
		st.setStationId(stid);
		DrailRail created = new DrailRail();
		created.setName(railName);
		created.setStation(st);
		created.setOrder(railOrder);
		return repo.save(created);
	}

}
