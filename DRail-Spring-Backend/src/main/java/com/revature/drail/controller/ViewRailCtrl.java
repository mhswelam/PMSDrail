package com.revature.drail.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.dto.DrailRailDTO;
import com.revature.drail.dto.DrailStationDTO;
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
	
	@PostMapping("/viewrails")
	public ResponseEntity<List<DrailRailDTO>> viewRails(@RequestBody DrailStationDTO stationDTO, HttpSession session) {
		System.out.println(stationDTO);
		List<DrailRailDTO> dtoLst = new ArrayList<>();
		for(int n: stationDTO.getRailIds()) {
			dtoLst.add(new DrailRailDTO(railSer.getRail(n)));
		}
		if (dtoLst.size() == 0) {
			return new ResponseEntity<List<DrailRailDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DrailRailDTO>>(dtoLst, HttpStatus.OK);
	}
}
