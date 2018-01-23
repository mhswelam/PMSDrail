package com.revature.drail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;
import com.revature.drail.dto.DrailStationDTO;
import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.service.UpdateStationService;

@RestController
public class UpdateStationCtrl {

	@Autowired
	UpdateStationService uss;

	@PostMapping("/updatestation")
	public ResponseEntity<DrailStationDTO> addingMemebers(@RequestBody DrailStationDTO updatedStation,
			HttpSession session) {

		DrailUser currentUser = (DrailUser) session.getAttribute("user");

		if (currentUser != null) {
			DrailUserRole RoleId = updatedStation.getUserRoleMap().get(currentUser.getUserId());

			if (RoleId != null && RoleId.getId() == DrailUserRole.PRODUCT_OWNER.getId()) {
				uss.updateStation(updatedStation);
				return new ResponseEntity<DrailStationDTO>(HttpStatus.ACCEPTED);
			}

			else {
				return new ResponseEntity<DrailStationDTO>(HttpStatus.UNAUTHORIZED);
			}

		}

		return new ResponseEntity<DrailStationDTO>(HttpStatus.BAD_REQUEST);

	}
}
