package com.revature.drail.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailStationViewDTO;
import com.revature.drail.dto.DrailStationsDTO;
import com.revature.drail.repo.DrailUserRepo;
import com.revature.drail.service.GetStationsService;


/**
 * 
 * @author cristian hermida
 *
 */

@RestController
public class GetStationsCtlr {
	
	@Autowired
	GetStationsService duService;

	
	
	@Autowired
	DrailUserRepo userRepo;

	@GetMapping("/getstations")
	public ResponseEntity<DrailStationsDTO> getStations(HttpSession session) {
		
		DrailUser currentUser = (DrailUser) session.getAttribute("user");
		List<DrailStationViewDTO> dsvDTO= new ArrayList<>();
		
		Set<DrailStation> dsSet = currentUser.getStations();
		System.out.println(dsSet);
		for(DrailStation ds : dsSet)
		{
			
			dsvDTO.add(new DrailStationViewDTO(ds));		
		}
		System.out.println(dsvDTO);
		DrailStationsDTO userStations = new DrailStationsDTO();
		userStations.setStations(dsvDTO);
		
		return new ResponseEntity<DrailStationsDTO>(userStations,HttpStatus.ACCEPTED);
		

	}

}
