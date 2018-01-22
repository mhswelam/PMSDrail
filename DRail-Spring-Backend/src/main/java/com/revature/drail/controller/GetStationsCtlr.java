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
/**
 * 
 * @author cristian
 *
 */
@RestController
public class GetStationsCtlr {
	
	@Autowired
	GetStationsService duService;
	
	@Autowired
	AddStationService dsService;
	
	@Autowired
	DrailUserRepo userRepo;

	/**
	 * Gets the stations of a user in the session.
	 * @param session
	 * @return the list of DrailStationViewDTO for the home page.
	 */
	@GetMapping("/getstations")
	public ResponseEntity<List<DrailStationViewDTO>> getStations(HttpSession session) {
		DrailUser currentUser = (DrailUser) session.getAttribute("user");
		List<DrailStation> dsMap = duService.getStations(currentUser);
		List<DrailStationViewDTO> allUserStations = new ArrayList<>();
		return new ResponseEntity<List<DrailStationViewDTO>>(allUserStations , HttpStatus.ACCEPTED);
		
	}

}
