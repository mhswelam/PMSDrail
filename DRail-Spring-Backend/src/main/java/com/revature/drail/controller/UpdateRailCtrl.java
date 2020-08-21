package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;
import com.revature.drail.dto.DrailRailDTO;
import com.revature.drail.dto.DrailStationDTO;
import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.service.UpdateRailService;

@RestController
public class UpdateRailCtrl {
	
	@Autowired
	UpdateRailService service;
	
	/**
	 * Persists changes to an existing task whose id matches [taskDTO.getTaskId()]
	 * @param taskDTO Should contain an existing task id
	 * @param session
	 * @return HttpStatus.ACCEPTED if update is successful, HttpStatus.UNAUTHORIZED if there is no user logged into the session
	 */
	@PostMapping("/updaterail")
	public ResponseEntity<DrailRail> updateRail(@RequestBody DrailRailDTO railDTO, HttpSession session) {
		if (session.getAttribute("user") != null) {
			service.updateRail(railDTO);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Updates the orders of the rails in [stationDTO]
	 * @param stationDTO The station whose rails are to be updated, this station's railIds list should be sorted so that the 
	 * @param session
	 * @return
	 */
	@PostMapping("/updaterailorder")
	public ResponseEntity<?> updateRailOrders(@RequestBody DrailStationDTO stationDTO, HttpSession session) {
		DrailUser currentUser = (DrailUser) session.getAttribute("user");
		if (currentUser == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		DrailUserDTO currentUserDTO = new DrailUserDTO(currentUser);
		DrailUserRole role =  currentUserDTO.getStationRoleMap().get(stationDTO.getStationId());
		
		if (role == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		service.updateRailOrder(stationDTO.getRailIds());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
