package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTask;

@RestController
public class AddTaskCtrl {
	
	public ResponseEntity<DrailTask> addTask(@RequestBody DrailTask task, HttpSession session) {
		
		return new ResponseEntity<DrailTask>(HttpStatus.UNAUTHORIZED);
	}

}
