package com.revature.drail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.service.AddUserService;


/**
 * 
 * @author Allan Poindexter
 *
 */

@RestController
public class AddUserCtrl {
	
	@Autowired
	AddUserService duService;
	
	/**
	 * Adds new user to database
	 * @param du - a new user
	 * @return Status 201 if user is added, or Status 409 if user already exists
	 */
	@PostMapping("/adduser")
	public ResponseEntity<DrailUser> addUser(@RequestBody DrailUser du) {
		try {
			duService.addUser(du);
			return new ResponseEntity<DrailUser>(HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<DrailUser>(HttpStatus.CONFLICT);
		}
		
	}
}
