package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.service.GetUserService;

@RestController
public class ViewProfileCtrl {
	
	@Autowired
	GetUserService guService;
	
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
	
	@PostMapping("/getuser")
	public ResponseEntity<DrailUserDTO> getUser(@RequestBody DrailUserDTO userDTO, HttpSession session) {
		System.out.println(userDTO);
		DrailUser currentUser = (DrailUser) session.getAttribute("user");
		if (currentUser != null && currentUser.getUserId() == userDTO.getUserId()) {
			DrailUserDTO result = new DrailUserDTO(guService.getUser(userDTO));
			return new ResponseEntity<DrailUserDTO>(result, HttpStatus.FOUND);
		}
		return new ResponseEntity<DrailUserDTO>(HttpStatus.UNAUTHORIZED);
	}

}
