package com.revature.drail.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.dto.DrailRailDTO;
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
	
//	@PostMapping("/viewtasks")
//	public ResponseEntity<List<DrailTaskDTO>> viewTasks(@RequestBody DrailTileDTO tileDTO, HttpSession session) {
//		List<DrailTaskDTO> dtoLst = new ArrayList<>();
//		for(int n : tileDTO.getTaskIds()) {
//			dtoLst.add(new DrailTaskDTO(service.getTaskById(n)));
//		}
//		if (dtoLst.size() == 0) {
//			return new ResponseEntity<List<DrailTaskDTO>>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<DrailTaskDTO>>(dtoLst, HttpStatus.OK);
//	}
	@PostMapping("/viewtasks")
	public ResponseEntity<List<DrailTaskDTO>> viewTasks(@RequestBody DrailTileDTO tileDTO, HttpSession session) {
//		List<DrailTaskDTO> dtoLst = new ArrayList<>();
//		for(int n : tileDTO.getTaskIds()) {
//			dtoLst.add(new DrailTaskDTO(service.getTaskById(n)));
//		}
//		if (dtoLst.size() == 0) {
//			return new ResponseEntity<List<DrailTaskDTO>>(HttpStatus.NO_CONTENT);
//		}
		System.out.println(tileDTO);
		return new ResponseEntity<List<DrailTaskDTO>>( HttpStatus.OK);
	}

}
