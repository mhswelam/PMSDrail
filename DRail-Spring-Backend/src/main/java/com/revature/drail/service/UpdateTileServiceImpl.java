package com.revature.drail.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public void updateTileOrders(List<Integer> tileIds) {
		List<DrailTile> tiles = new ArrayList<>();
		for(int i = 0; i < tileIds.size(); i++) {
			DrailTile tile = repo.findOne(tileIds.get(i));
			tile.setOrder(i);
			tiles.add(tile);
		}
		repo.save(tiles);
	}

		
}
