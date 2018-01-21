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
import com.revature.drail.repo.DrailUserRepo;
import com.revature.drail.service.AddStationService;
import com.revature.drail.service.GetStationsService;

@RestController
public class GetStationsCtlr {
	
	@Autowired
	GetStationsService duService;
	
	@Autowired
	AddStationService dsService;
	
	@Autowired
	DrailUserRepo userRepo;

	@GetMapping("/getstations")
	public ResponseEntity<List<DrailStationViewDTO>> getStations(HttpSession session) {
		//service that gets all stations that are for the user
		//DrailUser currentUser = (DrailUser) session.getAttribute("user");
		
		DrailUser currentUser = new DrailUser("testuser2", "pass", "Test", "User", "test@user.com");
		currentUser.setUserId(107);
		//System.out.println(userRepo.findAll());
		//returns hashmap
		System.out.println(currentUser);
		List<DrailStation> dsMap = duService.getStations(currentUser);
		System.out.println(dsMap);
		//get all stations with the id and store in array.
		List<DrailStationViewDTO> allUserStations = new ArrayList<>();
//		for(DrailStation ds : dsMap) {
//			System.out.println(ds);
//			allUserStations.add((DrailStationViewDTO)ds);
//		}
		//return new ResponseEntity<DrailUser>(new DrailUserDTO(currentUser), HttpStatus.ACCEPTED);
		return new ResponseEntity<List<DrailStationViewDTO>>(allUserStations , HttpStatus.ACCEPTED);
		
	}

}
