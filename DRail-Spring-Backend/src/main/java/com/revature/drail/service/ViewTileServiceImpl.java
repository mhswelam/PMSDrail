package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailTile;
import com.revature.drail.repo.DrailTileRepo;

@Service
public class ViewTileServiceImpl implements ViewTileService {

	@Autowired
	DrailTileRepo repo;

	@Override
	public DrailTile viewTileById(int id) {
		return repo.findOne(id);
	}
	
	
}
