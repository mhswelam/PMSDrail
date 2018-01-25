package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.repo.DrailRailRepo;

@Service
public class GetRailServiceImpl implements GetRailService {
	
	
	
	@Autowired
	DrailRailRepo repo;

	@Override
	public DrailRail getRail(int railId) {
		
		return repo.findOne(railId);
	}

}
