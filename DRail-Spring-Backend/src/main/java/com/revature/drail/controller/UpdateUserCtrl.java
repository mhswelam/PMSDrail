package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailUserDTO;
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
	public ResponseEntity<DrailUser> updateUser(@RequestBody DrailUserDTO dto, HttpSession session) {
		DrailUser current = (DrailUser) session.getAttribute("user");
		
		if ( current != null && current.getUserId() == dto.getUserId()) {
			try {
				DrailUser updated = current;
				
				updated.setFirstname(dto.getFirstname());
				updated.setLastname(dto.getLastname());
				updated.setEmail(dto.getEmail());
				
				if (dto.getPassword().equals("")) {
					updated.setPassword(current.getPassword());
				} else {
					updated.setPassword(dto.getPassword());
				}
				
				duService.updateUser(updated);
				session.setAttribute("user", updated);
				return new ResponseEntity<DrailUser>(HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<DrailUser>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<DrailUser>(HttpStatus.CONFLICT);
		}
		
		
	}

}
