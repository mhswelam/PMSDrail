package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;
import com.revature.drail.dto.DrailRailDTO;
import com.revature.drail.dto.DrailTileDTO;
import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.service.GetStationService;
import com.revature.drail.service.UpdateTileService;

@RestController
public class UpdateTileCtrl {

	@Autowired
	UpdateTileService utService;
	@Autowired
	GetStationService stnService;
	
	/**
	 * Update a tile
	 * @param ut - A tile to be updated.
	 * @return Status 200 if updated, 409 if there is an issue
	 */
	@PostMapping("/updatetile")
	public ResponseEntity<DrailTile> updateTile(@RequestBody DrailTileDTO dto, HttpSession session) {
		
		DrailUser currentUser = (DrailUser)session.getAttribute("user");
		if (currentUser == null) return new ResponseEntity<DrailTile>(HttpStatus.UNAUTHORIZED);
		
		DrailStation station = stnService.getStationByRail(dto.getRailId());
		DrailUserRole role =  currentUser.getStationRoleMap().get(station);
		
		if (role != null && role.getId() != DrailUserRole.SCRUM_MASTER.getId()){
			return new ResponseEntity<DrailTile>(HttpStatus.UNAUTHORIZED);
		}
		
		try {
			DrailTile tile = new DrailTile(dto);
			tile.setUserCheckedOut(currentUser);
			utService.updateTile(tile);
			return new ResponseEntity<DrailTile>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DrailTile>(HttpStatus.CONFLICT);
		}
	}
	
	/**
	 * For each rail in [railDTOs], updates order and railId of the tiles in that rail. This should be used both for persisting movement within a
	 * rail and movement between rails.  
	 * @param railDTOs Contains the rails whose tiles will be updated
	 * @param session
	 * @return OK if update is successful, UNAUTHORIZED if no user is logged in or the current user has no role on the current station, BAD_REQUEST
	 * if the array of rails is empty.
	 */
	@PostMapping("/updatetileorder")
	public ResponseEntity<DrailRailDTO> updateTileOrders(@RequestBody DrailRailDTO[] railDTOs, HttpSession session) {
		DrailUser currentUser = (DrailUser) session.getAttribute("user");
		if (currentUser == null) return new ResponseEntity<DrailRailDTO>(HttpStatus.UNAUTHORIZED);
		
		if (railDTOs.length == 0) return new ResponseEntity<DrailRailDTO>(HttpStatus.BAD_REQUEST);
		
		DrailUserDTO currentDTO = new DrailUserDTO(currentUser);
//		DrailStation station = stnService.getStationByRail(railDTOs[0].getRailId());
		DrailUserRole role =  currentDTO.getStationRoleMap().get(railDTOs[0].getStationId());
		
		if (role == null) return new ResponseEntity<DrailRailDTO>(HttpStatus.UNAUTHORIZED);
		
		for(DrailRailDTO rail : railDTOs) {
			utService.updateTileOrders(rail.getTileIds(), rail.getRailId());
		}
		return new ResponseEntity<DrailRailDTO>(HttpStatus.OK);
	}
	
/*	@PostMapping("/updatetileorder")
	public ResponseEntity<DrailRailDTO> updateTileOrders(@RequestBody DrailRailDTO railDTO, HttpSession session) {
		DrailUser currentUser = (DrailUser) session.getAttribute("user");
		if (currentUser == null) return new ResponseEntity<DrailRailDTO>(HttpStatus.UNAUTHORIZED);
		
		DrailStation station = stnService.getStationByRail(railDTO.getRailId());
		DrailUserRole role =  currentUser.getStationRoleMap().get(station);
		
		if (role == null) return new ResponseEntity<DrailRailDTO>(HttpStatus.UNAUTHORIZED);
		
		utService.updateTileOrders(railDTO.getTileIds());
		return new ResponseEntity<DrailRailDTO>(HttpStatus.OK);
	}*/
	
	
}
