package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.service.UpdateUserService;

@RestController
public class UpdateUserCtrl {
	
	
	@Autowired
	UpdateUserService duService;
	
	/**
	 * Update a user
	 * @param du - a user to be updated all user field are still  required  except password can be empty string if no update.
	 * @return Status 201 if user is updated, or Status 409 if updated 
	 */
	@PostMapping("/updateuser")
	public ResponseEntity<DrailUser> updateUser(@RequestBody DrailUser du, HttpSession session) {
		DrailUser current = (DrailUser) session.getAttribute("user");
		if (du.getPassword().equals("")) {
			du.setPassword(current.getPassword());
		}
		if ( current != null && current.getUserId() == du.getUserId()) {
			try {
				
				duService.updateUser(du);
				session.setAttribute("user", du);
				return new ResponseEntity<DrailUser>(HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ResponseEntity<DrailUser>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<DrailUser>(HttpStatus.CONFLICT);
		}
		
		
	}

}
