package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.repo.DrailTileRepo;

@Service
public class AddTileServiceImpl implements AddTileService {

	@Autowired
	DrailTileRepo repo;

	@Override
	public DrailTile addTile(DrailTile dt, DrailRail dr, DrailUser du) {
		//TODO Get User Session and Current Rail
		dt.setUserCheckedOut(du);
		dt.setRail(dr);
		return dt = repo.save(dt);
	}

}
