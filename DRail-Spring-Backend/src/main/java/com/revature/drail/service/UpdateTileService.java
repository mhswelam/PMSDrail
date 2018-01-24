package com.revature.drail.service;

import java.util.List;

import com.revature.drail.beans.DrailTile;

public interface UpdateTileService {
	
	public void updateTile(DrailTile ut);
	
	/**
	 * Updates the order and rail of the tile whose id is in [tileIds]
	 * @param tileIds The tile at index [i] will have its order set to [i]
	 * @param railId Each tile will have its rail set to the rail whose id = [railId]
	 */
	public void updateTileOrders(List<Integer> tileIds, int railId);

}
