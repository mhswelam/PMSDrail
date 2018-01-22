package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailTileDTO;
import com.revature.drail.repo.DrailTileRepo;

@Service
public class AddTileServiceImpl implements AddTileService {

	@Autowired
	DrailTileRepo repo;

	@Override
	public DrailTile addTile(DrailTile tile) {
		return repo.save(tile);
	}

}
