package com.revature.drail.service;

import java.util.List;

import com.revature.drail.beans.DrailTile;

public interface UpdateTileService {
	
	public void updateTile(DrailTile ut);
	
	public void updateTileOrders(List<Integer> tileIds);

}
