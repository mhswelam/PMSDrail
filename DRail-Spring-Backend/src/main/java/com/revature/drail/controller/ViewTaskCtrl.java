package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.dto.DrailTaskDTO;
import com.revature.drail.dto.DrailTileDTO;
import com.revature.drail.service.GetService;
/**
 * 
 * @author cristian
 *
 */
@RestController
public class ViewTaskCtrl {
	
	
	@Autowired
	GetService service;
	/**
	 *  Will return the task with matching Id in the DrailTaskDTO json. If station does not exist it will return 
	 * an HTTP status of 204. If session is not active then it will return 401.
	 * 
	 * @param taskDTO
	 * @return returns DrailTaskDTO with matching id and status 200. or status of 204.
	 */
	@PostMapping("/viewtask")
	public ResponseEntity<DrailTaskDTO> viewTask(@RequestBody DrailTaskDTO taskDTO, HttpSession session) {
		DrailTask task = service.getTaskById(taskDTO.getTaskId());
		if(session == null) {
			return new ResponseEntity<DrailTaskDTO>(HttpStatus.UNAUTHORIZED);
		}else {
			if (task != null) {
				return new ResponseEntity<DrailTaskDTO>(new DrailTaskDTO(task),HttpStatus.OK);
			} else {
				return new ResponseEntity<DrailTaskDTO>(new DrailTaskDTO(),HttpStatus.NO_CONTENT);
			}
		}
	}

}
