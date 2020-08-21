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
public class UpdateTaskCtrl {
	
	@Autowired
	AddTaskService service;
	
	/**
	 * Persists changes to an existing task whose id matches [taskDTO.getTaskId()]
	 * @param taskDTO Should contain an existing task id
	 * @param session
	 * @return HttpStatus.ACCEPTED if update is successful, HttpStatus.UNAUTHORIZED if there is no user logged into the session
	 */
	@PostMapping("/updatetask")
	public ResponseEntity<?> updateTask(@RequestBody DrailTaskDTO taskDTO, HttpSession session) {
		if (session.getAttribute("user") != null) {
			service.saveTask(taskDTO);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
