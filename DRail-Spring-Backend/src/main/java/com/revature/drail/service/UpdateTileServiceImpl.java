package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailTile;
import com.revature.drail.repo.DrailTileRepo;

@Service
public class UpdateTileServiceImpl implements UpdateTileService {
	
	@Autowired
	DrailTileRepo repo;

	@Override
	public void updateTile(DrailTile ut) {
		repo.save(ut);
	}

		
}
