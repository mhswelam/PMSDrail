package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailStation;
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
	 * an HTTP status of 204.
	 * @param id of the station
	 * @param session must be a valid session
	 * @return DrailStationDTO json and status 200, or a status of 401 if session is invalid or station does not exist, or status 204 for no content.
	 */
	@PostMapping("/viewstation")
	public ResponseEntity<DrailStationDTO> viewProfile(@RequestBody DrailStationDTO respStationDto,HttpSession session) {
		if(session == null) {
			return new ResponseEntity<DrailStationDTO>(HttpStatus.UNAUTHORIZED);
		}else {
			
			DrailStation stDto = stService.viewStationById(respStationDto.getStationId());
			if(stDto == null) {
				return new ResponseEntity<DrailStationDTO>(HttpStatus.NO_CONTENT);
			}
			else
			{
				return new ResponseEntity<DrailStationDTO>(new DrailStationDTO(stDto), HttpStatus.OK);
			}
			
		}
		
		
		
		
	}
}
