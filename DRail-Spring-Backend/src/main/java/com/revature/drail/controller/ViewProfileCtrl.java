package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailUserDTO;

@RestController
public class ViewProfileCtrl {
	
	/**
	 * Gets the profile details of the user currently logged in on this session
	 * @param session The HttpSession of the GET request
	 * @return A DrailUserDTO along with response code 200 (OK) if there is a user logged onto the session, or 401 
	 * 		   (UNAUTHORIZED) otherwise
	 */
	@GetMapping("/viewprofile")
	public ResponseEntity<DrailUserDTO> viewProfile(HttpSession session) {
		DrailUser currentUser = (DrailUser) session.getAttribute("user");
		if (currentUser != null && currentUser.getUserId() > 0) {
			return new ResponseEntity<DrailUserDTO>(new DrailUserDTO(currentUser), HttpStatus.OK);
		}
		return new ResponseEntity<DrailUserDTO>(new DrailUserDTO(currentUser), HttpStatus.UNAUTHORIZED);
	}

}
