package com.revature.drail.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.service.AddTileService;

/**
 * 
 * @author Allan Poindexter
 *
 */

@RestController
public class AddTileCtrl {
	
	@Autowired
	AddTileService tsService;
	
	/**
	 * Adds a tile to a rail
	 * @param dt - The tile to be created
	 * @return
	 */
	@PostMapping("/addtile")
	public ResponseEntity<DrailTile> addTile(@RequestBody DrailTile dt) {
		try {
			//TODO Get User Session
			DrailUser du = new DrailUser("test", "pass", "test", "user", "test@user.com");
			du.setUserId(107);
			
			//TODO Get the current Rail, somehow. 
			DrailRail dr = new DrailRail();
			dr.setRailId(1);
			
			tsService.addTile(dt, dr, du);
			return new ResponseEntity<DrailTile>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DrailTile>(HttpStatus.CONFLICT);
		}
	}
}
