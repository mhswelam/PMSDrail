package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;
import com.revature.drail.dto.DrailStationDTO;
import com.revature.drail.repo.DRailURSRepo;
import com.revature.drail.repo.DrailStationRepo;
import com.revature.drail.repo.DrailUserRepo;

@Service
public class AddStationServiceImpl implements AddStationService {

	@Autowired
	DrailStationRepo repo;
	@Autowired
	DrailUserRepo userRepo;
	@Autowired
	DRailURSRepo ursRepo;
	
	@Override
	public DrailStationDTO addStation(DrailUser du, DrailStation ds) {
		ds.getUsers().add(du);
		du.getStations().add(ds);
		//userRepo.save(du);
		DrailStation newStation = repo.save(ds);
		ursRepo.modifyURS(DrailUserRole.PRODUCT_OWNER, du, ds);
		return new DrailStationDTO(newStation);
		
	}

}
