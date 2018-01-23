package com.revature.drail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.dto.DrailTaskDTO;
import com.revature.drail.service.GetService;

@RestController
public class ViewTaskCtrl {
	
	@Autowired
	GetService service;
	
	@PostMapping("/viewtask")
	public ResponseEntity<DrailTaskDTO> viewTask(@RequestBody DrailTaskDTO taskDTO) {
		DrailTask task = service.getTaskById(taskDTO.getTaskId());
		
		if (task != null) {
			return new ResponseEntity<DrailTaskDTO>(new DrailTaskDTO(task),HttpStatus.OK);
		} else {
			return new ResponseEntity<DrailTaskDTO>(new DrailTaskDTO(),HttpStatus.NO_CONTENT);
		}
	}

}
