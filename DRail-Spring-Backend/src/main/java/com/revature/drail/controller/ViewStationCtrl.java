package com.revature.drail.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailStationDTO;
import com.revature.drail.service.ViewStationService;

/**
 * 
 * @author cristian hermida
 *
 */
@RestController
public class ViewStationCtrl {

	@Autowired
	ViewStationService stService;
	
	/**
	 * Will return the station with matching Id in the DrailStationDTO json. If station does not exist it will return 
	 * an HTTP status of UNAUTHORIZED
	 * @param id of the station
	 * @param session must be a valid session
	 * @return DrailStationDTO json and status 201, or a status of 401 if session is invalid or station does not exist.
	 */
	@PostMapping("/viewstation")
	public ResponseEntity<DrailStationDTO> viewProfile(@RequestBody DrailStationDTO respStationDto,HttpSession session) {
		if(session == null) {
			return new ResponseEntity<DrailStationDTO>(HttpStatus.UNAUTHORIZED);
		}else {
			DrailUser currentUser = (DrailUser) session.getAttribute("user");
			Set<DrailStation> stSet = currentUser.getStationRoleMap().keySet();
			
			DrailStation stView = null;
			for(DrailStation st: stSet) {
				if(st.getStationId() == respStationDto.getStationId()) {
					stView = st;
				}
			}
			
			if (stView == null) {
				return new ResponseEntity<DrailStationDTO>(HttpStatus.UNAUTHORIZED);
			}else{
				DrailStation dStation = stService.viewStationById(stView.getStationId());
				DrailStationDTO stDto = new DrailStationDTO(dStation);
				return new ResponseEntity<DrailStationDTO>(stDto, HttpStatus.ACCEPTED);
			}
		}
		
		
		
		
	}
}
