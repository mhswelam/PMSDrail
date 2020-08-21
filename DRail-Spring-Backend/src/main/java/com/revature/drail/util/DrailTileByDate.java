package com.revature.drail.util;

import java.util.Comparator;

import com.revature.drail.beans.DrailTile;

public class DrailTileByDate implements Comparator<DrailTile> {

	@Override
	public int compare(DrailTile o1, DrailTile o2) {
		
		if (o1.getDateCompleted().equals(o2.getDateCompleted())) {
			return 0;
		}
		
		if (o1.getDateCompleted().before(o2.getDateCompleted())) {
			return -1;
		} else {
			return 1;
		}
	}

} 
