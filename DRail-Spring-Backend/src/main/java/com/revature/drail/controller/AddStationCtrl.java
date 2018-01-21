package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailStationDTO;
import com.revature.drail.service.AddStationService;

@RestController
public class AddStationCtrl {

	@Autowired
	AddStationService dsService;
	
	@PostMapping("/addstation")
	public ResponseEntity<DrailStationDTO> addStation(@RequestBody DrailStation ds,HttpSession session) {
		try {
			DrailUser du = (DrailUser) session.getAttribute("user");
			
			if(du!=null) {
			DrailStationDTO stationDTO = dsService.addStation(du, ds);
			return new ResponseEntity<DrailStationDTO>(stationDTO,HttpStatus.CREATED);
																				}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DrailStationDTO>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<DrailStationDTO>(HttpStatus.UNAUTHORIZED);
	}
	
}
