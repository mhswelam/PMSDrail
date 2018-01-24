package com.revature.drail.service;

import java.util.List;

import com.revature.drail.beans.DrailTile;

public interface MoveTileService {
	
	/**
	 * Persists the order of [tiles] to the database
	 * @param tiles A list of Tiles on a single rail, should be in the desired order
	 * @return The list that was saved to the database
	 */
	public List<DrailTile> moveTiles(List<DrailTile> tiles);

}
