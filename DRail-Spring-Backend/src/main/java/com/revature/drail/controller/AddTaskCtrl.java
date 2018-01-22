package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.dto.DrailTaskDTO;
import com.revature.drail.service.AddTaskService;

@RestController
public class AddTaskCtrl {
	
	@Autowired
	AddTaskService service;
	
	/**
	 * Persists [taskDTO] as a DrailTask
	 * @param taskDTO Should contain ID of parent Tile
	 * @param session 
	 * @return HttpStatus.CREATED if successful, HttpStatus.UNAUTHORIZED if no user is logged into the session
	 */
	@PostMapping("/addtask")
	public ResponseEntity<?> addTask(@RequestBody DrailTaskDTO taskDTO, HttpSession session) {
		if (session.getAttribute("user") != null) {
			service.saveTask(taskDTO);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
