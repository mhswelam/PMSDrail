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
import com.revature.drail.service.GetUserByUsernameService;

@RestController
public class GetUserCtrl {
	
	@Autowired
	private GetUserByUsernameService userService;

	@PostMapping("/getuserinfo")
	public ResponseEntity<DrailUserDTO> getUserInfo(@RequestBody String username, HttpSession session) {
		if (session == null) {
			return new ResponseEntity<DrailUserDTO>(HttpStatus.UNAUTHORIZED);
		} else {
			DrailUser user = userService.getUserByUsername(username) ;
			return new ResponseEntity<DrailUserDTO>(new DrailUserDTO(user),HttpStatus.OK);
		}
	}
}
