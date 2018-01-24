package com.revature.drail.service;

import java.util.List;

import com.revature.drail.dto.DrailRailDTO;

public interface UpdateRailService {
	
	public void updateRail(DrailRailDTO railDTO);
	
	/**
	 * Updates the order of the rails whose ids are in [railIds]
	 * @param railIds The rail whose id = railIds[i] will have its order set to i
	 */
	public void updateRailOrder(List<Integer> railIds);
	
}
