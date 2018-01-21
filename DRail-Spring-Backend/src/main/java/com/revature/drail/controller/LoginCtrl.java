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
import com.revature.drail.service.LoginService;

@RestController
public class LoginCtrl {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<DrailUserDTO> login(@RequestBody DrailUser du, HttpSession session) {
		DrailUser currentUser = loginService.login(du);
		if (currentUser.getUserId() > 0) {
			session.setAttribute("user", currentUser);
			return new ResponseEntity<DrailUserDTO>(new DrailUserDTO(currentUser), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<DrailUserDTO>(new DrailUserDTO(currentUser), HttpStatus.UNAUTHORIZED);
	}

}
