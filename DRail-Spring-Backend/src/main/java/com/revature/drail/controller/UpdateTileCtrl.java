package com.revature.drail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.service.UpdateTileService;

@RestController
public class UpdateTileCtrl {

	@Autowired
	UpdateTileService utService;
	
	/**
	 * Update a tile
	 * @param ut - A tile to be updated.
	 * @return Status 200 if updated, 409 if there is an issue
	 */
	@PostMapping("/updatetile")
	public ResponseEntity<DrailTile> updateTile(@RequestBody DrailTile ut) {
		try {
			//TODO Get User Session
			DrailUser du = new DrailUser("test", "pass", "test", "user", "test@user.com");
			du.setUserId(107);
			
			//TODO Get the current Rail, somehow. 
			DrailRail dr = new DrailRail();
			dr.setRailId(1);
			
			ut.setUserCheckedOut(du);
			ut.setRail(dr);
			utService.updateTile(ut);
			return new ResponseEntity<DrailTile>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DrailTile>(HttpStatus.CONFLICT);
		}
	}
	
}
