package com.revature.drail.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailURS;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;
import com.revature.drail.dto.DrailTileDTO;
import com.revature.drail.service.GetStationService;
import com.revature.drail.service.GetURSService;
import com.revature.drail.service.UpdateTileService;

@RestController
public class UpdateTileCtrl {

	@Autowired
	UpdateTileService utService;
	
	@Autowired
	GetStationService stnService;
	
	@Autowired
	GetURSService ursService;
	
	/**
	 * Update a tile
	 * @param ut - A tile to be updated.
	 * @return Status 200 if updated, 409 if there is an issue
	 */
	@PostMapping("/updatetile")
	public ResponseEntity<DrailTile> updateTile(@RequestBody DrailTile dt, HttpSession session) {
		
		DrailUser currentUser = (DrailUser)session.getAttribute("user");
		if (currentUser == null) return new ResponseEntity<DrailTile>(HttpStatus.UNAUTHORIZED);
		
		//Use the current Rail to get the Station
		DrailStation station = stnService.getStationByRail(dt.getRail().getRailId());
		
		//Now using the Station and the User, get the user's role.
		DrailURS urs = ursService.getStationURS(currentUser, station);

		if (urs.getRole().getId() != DrailUserRole.SCRUM_MASTER.getId()) {
			return new ResponseEntity<DrailTile>(HttpStatus.UNAUTHORIZED);
		}
		
		try {
			utService.updateTile(dt);
			return new ResponseEntity<DrailTile>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DrailTile>(HttpStatus.CONFLICT);
		}
	}
	
}
