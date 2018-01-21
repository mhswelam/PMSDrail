package com.revature.drail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailTile;
import com.revature.drail.repo.DrailTileRepo;

@Service
public class MoveTileServiceImpl implements MoveTileService {

	@Autowired
	DrailTileRepo tileRepo;
	
	@Override
	public List<DrailTile> moveTiles(List<DrailTile> tiles) {
		for(int i = 0; i < tiles.size(); i++) {
			tiles.get(i).setOrder(i);
		}
		return tileRepo.save(tiles);
	}

}
