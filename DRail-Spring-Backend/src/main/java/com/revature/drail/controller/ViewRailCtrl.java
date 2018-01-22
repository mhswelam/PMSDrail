package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.dto.DrailRailDTO;
import com.revature.drail.service.GetRailService;

@RestController
public class ViewRailCtrl {
	
	@Autowired
	GetRailService railSer;
	

	
	@PostMapping("/viewrail")
	public ResponseEntity<DrailRailDTO> viewRail(@RequestBody DrailRailDTO railDto, HttpSession session) {
		DrailRail sendOut = railSer.getRail(railDto.getRailId());
		
		if (sendOut != null) {
			return new ResponseEntity<DrailRailDTO>(new DrailRailDTO(sendOut),HttpStatus.OK);
		} else {
			return new ResponseEntity<DrailRailDTO>(new DrailRailDTO(),HttpStatus.NO_CONTENT);
		}
		
		
	}
}
