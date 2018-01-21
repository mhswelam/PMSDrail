package com.revature.drail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTile;
import com.revature.drail.service.MoveTileService;

@RestController
public class MoveTileCtrl {
	
	@Autowired
	private MoveTileService mtService;
	
	/**
	 * Persists current order of [tiles] to the database
	 * @param tiles A list of Tiles on a single rail, should be in the desired order
	 * @return The list that was saved to the database
	 */
	@PostMapping("/movetile")
	public ResponseEntity<List<DrailTile>> moveTile(@RequestBody List<DrailTile> tiles) {
		tiles = mtService.moveTiles(tiles);
		return new ResponseEntity<List<DrailTile>>(tiles, HttpStatus.OK);
	}

}
