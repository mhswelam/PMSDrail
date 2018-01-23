package com.revature.drail.service;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.beans.DrailTile;

public interface GetService {
	
	public DrailTile getTileById(int tileId);
	
	public DrailTask getTaskById(int taskId);

}
