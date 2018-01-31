package com.revature.drail.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailRailDTO;
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
	 * If tile does not exist it will return an HTTP status of 204
	 * @param respTileDto must have tileId
	 * @param session must be a valid session
	 * @return DrailTileDTO json and status 200, or status 401 if session is invalid
	 */
	@PostMapping("/viewtile")
	public ResponseEntity<DrailTileDTO> viewTile(@RequestBody DrailTileDTO respTileDto  ,HttpSession session){
		if(session == null) {
			return new ResponseEntity<DrailTileDTO>(HttpStatus.UNAUTHORIZED);
		}else {
			DrailTile dt = tileService.viewTileById(respTileDto.getTileId());
			if(dt ==null) {
				return new ResponseEntity<DrailTileDTO>(HttpStatus.NO_CONTENT);
			}else {
				DrailTileDTO dtDto = new DrailTileDTO(dt);
				if (dtDto != null) {
					Collections.sort(dtDto.getTasks());
				}
				return new ResponseEntity<DrailTileDTO>(dtDto,HttpStatus.OK);
			}
		}
	}
	
	@PostMapping("/viewtiles")
	public ResponseEntity<List<DrailTileDTO>> viewTiles(@RequestBody DrailRailDTO railDTO, HttpSession session) {
		List<DrailTileDTO> dtoLst = new ArrayList<>();
		for(int n : railDTO.getTileIds()) {
			dtoLst.add(new DrailTileDTO(tileService.viewTileById(n)));
		}
		if (dtoLst.size() == 0) {
			return new ResponseEntity<List<DrailTileDTO>>(HttpStatus.NO_CONTENT);
		}
		Collections.sort(dtoLst);
		return new ResponseEntity<List<DrailTileDTO>>(dtoLst, HttpStatus.OK);
	}
}
