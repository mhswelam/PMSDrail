package com.revature.drail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailTileDTO;
import com.revature.drail.service.GetService;

@RestController
public class ViewTileCtrl {
	
	@Autowired
	GetService service;
	
	@PostMapping("/viewtile")
	public ResponseEntity<DrailTileDTO> viewTile(@RequestBody DrailTileDTO tileDTO) {
		DrailTile tile = service.getTileById(tileDTO.getTileId());
		
		if (tile != null) {
			return new ResponseEntity<DrailTileDTO>(new DrailTileDTO(tile),HttpStatus.OK);
		} else {
			return new ResponseEntity<DrailTileDTO>(new DrailTileDTO(),HttpStatus.NO_CONTENT);
		}
	}

}
