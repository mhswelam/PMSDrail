package com.revature.drail.controller;

import java.util.ArrayList;
import java.util.List;

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
 * @author cristian hermida
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
	 * This will return a list of DrailStationViewDTO.
	 * If does not exist it will return an HTTP status of UNAUTHORIZED
	 * @param session
	 * @return List of DrailStationViewDTO and status 202, or 401 if session is invalid
	 */
	@GetMapping("/getstations")
	public ResponseEntity<List<DrailStationViewDTO>> getStations(HttpSession session) {
		if (session == null) {
			return new ResponseEntity<List<DrailStationViewDTO>>(HttpStatus.UNAUTHORIZED);
		}else {
			DrailUser currentUser = (DrailUser) session.getAttribute("user");
			List<DrailStation> dsMap = duService.getStations(currentUser);
			List<DrailStationViewDTO> allUserStations = new ArrayList<>();
			for(DrailStation ds : dsMap) {
				allUserStations.add(new DrailStationViewDTO(ds));
			}
			return new ResponseEntity<List<DrailStationViewDTO>>(allUserStations , HttpStatus.ACCEPTED);
		}
	}

}
