package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailStationsDTO;
import com.revature.drail.service.GetStationsService;
/**
 * 
 * @author cristian hermida
 *
 */
@CrossOrigin
@RestController
public class GetStationsCtlr {
	
	@Autowired
	GetStationsService duService;

	/**
	 * This will return a list of DrailStationViewDTO.
	 * If does not exist it will return an HTTP status of UNAUTHORIZED
	 * @param session
	 * @return List of DrailStationViewDTO and status 200, or 401 if session is invalid
	 */
	@GetMapping("/getstations")
	public ResponseEntity<DrailStationsDTO> getStations(HttpSession session) {
		if (session == null) {
			return new ResponseEntity<DrailStationsDTO>(HttpStatus.UNAUTHORIZED);
		}else {
			DrailStationsDTO userStations = duService.getStations((DrailUser)session.getAttribute("user"));
			return new ResponseEntity<DrailStationsDTO>(userStations , HttpStatus.OK);
		}
	}

}
