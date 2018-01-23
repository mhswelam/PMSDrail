package com.revature.drail.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTile;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailTileDTO;
import com.revature.drail.service.ViewTileService;
/**
 * 
 * @author cristian hermida
 *
 */
@RestController
public class ViewTileCtrl {

	@Autowired
	ViewTileService tileService;
	/**
	 * This will return a DrailTileDTO json that matches the id of the DrailTileDTO json that is sent in the request.
	 * If tile does not exist it will return an HTTP status of UNAUTHORIZED
	 * @param respTileDto must have tileId
	 * @param session must be a valid session
	 * @return DrailTileDTO json and status 202, or status 401 if session is invalid
	 */
	@PostMapping("/viewtile")
	public ResponseEntity<DrailTileDTO> viewTile(@RequestBody DrailTileDTO respTileDto  ,HttpSession session){
		if(session == null) {
			return new ResponseEntity<DrailTileDTO>(HttpStatus.UNAUTHORIZED);
		}else {
			DrailTile dt = tileService.viewTileById(respTileDto.getTileId());
			DrailTileDTO dtDto = new DrailTileDTO(dt);
			return new ResponseEntity<DrailTileDTO>(dtDto,HttpStatus.ACCEPTED);
		}

	}
}
