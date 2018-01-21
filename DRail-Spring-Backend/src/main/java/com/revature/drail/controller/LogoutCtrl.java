package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutCtrl {
	
	
	
	@GetMapping("/logout")
	public HttpStatus logout(HttpSession session) {
		session.invalidate();
		return (HttpStatus.ACCEPTED);
	
	}

}
