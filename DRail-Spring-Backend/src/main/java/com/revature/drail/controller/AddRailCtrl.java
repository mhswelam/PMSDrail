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
import com.revature.drail.dto.DrailRailDTO;
import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.repo.DRailURSRepo;
import com.revature.drail.repo.DrailStationRepo;
import com.revature.drail.service.AddRailService;

@RestController
public class AddRailCtrl {

	@Autowired
	AddRailService railser;
	@Autowired
	DRailURSRepo urs;
	@Autowired
	DrailStationRepo stRepo;

	@PostMapping("/addrail")
	public ResponseEntity<?> addRail(@RequestBody DrailRailDTO rail, HttpSession session) {

		DrailUser current = (DrailUser) session.getAttribute("user");
		DrailUserDTO currentDTO = new DrailUserDTO(current);

		if (current == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		DrailUserRole role = currentDTO.getStationRoleMap().get(rail.getStationId());
		if (role == null || (role.getId() != DrailUserRole.PRODUCT_OWNER.getId() && role.getId() != DrailUserRole.SCRUM_MASTER.getId())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		railser.addRail(rail);
		return new ResponseEntity<>(HttpStatus.CREATED);

		// if ((urs.findByUserInAndStationIn(current,
		// stRepo.findOne(rail.getStationId()))).getRole().getId() ==
		// DrailUserRole.SCRUM_MASTER.getId()) {
		// try {
		// railser.addRail(rail.getStationId(), rail.getName(), rail.getOrder());
		// return new ResponseEntity<DrailStationDTO>(HttpStatus.ACCEPTED);
		// } catch (Exception e) {
		// e.printStackTrace();
		// return new ResponseEntity<>(HttpStatus.CONFLICT);
		// }
		//
		// } else {
		// return new ResponseEntity<DrailStationDTO>(HttpStatus.CONFLICT);
		// }
		//
	}

}
