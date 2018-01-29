package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.dto.DrailChartDTO;
import com.revature.drail.dto.DrailChartOutDTO;
import com.revature.drail.service.GetBChartService;

@RestController
public class ViewBChartCtrl {
	
	@Autowired
	GetBChartService chartServ;
	
	
	
	
	
	@PostMapping("/viewchart")
	public ResponseEntity<DrailChartOutDTO> viewBChart(@RequestBody DrailChartDTO chartDto, HttpSession session) {
		
		if (session.getAttribute("user") != null) {
			
			return new ResponseEntity<DrailChartOutDTO>(chartServ.getChartDto(chartDto),HttpStatus.OK);
		} else {
			return new ResponseEntity<DrailChartOutDTO>(HttpStatus.NO_CONTENT);
		}
		

	}
	
	

}
