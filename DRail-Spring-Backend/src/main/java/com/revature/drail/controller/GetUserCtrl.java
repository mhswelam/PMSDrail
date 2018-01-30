package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.service.GetUserService;

@CrossOrigin
@RestController
public class GetUserCtrl {
	@Autowired
	GetUserService getUser;
	
	@PostMapping("/getuser")
	public ResponseEntity<DrailUserDTO> getStations(@RequestBody String username, HttpSession session) {
		if (session == null) {
			return new ResponseEntity<DrailUserDTO>(HttpStatus.UNAUTHORIZED);
		}else {
			//DrailStationsDTO userStations = duService.getStations((DrailUser)session.getAttribute("user"));
			DrailUserDTO userInfo = getUser.getUserByUsername(username);
			return new ResponseEntity<DrailUserDTO>(userInfo , HttpStatus.OK);
		}
	}

}
