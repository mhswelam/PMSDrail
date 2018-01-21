package com.revature.drail.service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailUser;

public interface AddTileService {

	public DrailTile addTile(DrailTile dt, DrailRail dr, DrailUser du);
}
