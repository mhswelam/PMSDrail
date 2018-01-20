package com.revature.drail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.service.AddStationService;

@RestController
public class AddStationCtrl {

	@Autowired
	AddStationService dsService;
	
	@PostMapping("/addstation")
	public ResponseEntity<DrailStation> addStation(@RequestBody DrailStation ds) {
		try {
			//TODO Get User Session
			DrailUser du = new DrailUser("test", "pass", "test", "user", "test@user.com");
			du.setUserId(107);
			
			dsService.addStation(du, ds);

			return new ResponseEntity<DrailStation>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<DrailStation>(HttpStatus.CONFLICT);
		}
	}
	
}
