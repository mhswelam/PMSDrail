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

	@Override
	public DrailStation addStation(DrailUser du, DrailStation ds) {
		du.getStationRoleMap().put(ds, DrailUserRole.PRODUCT_OWNER);
		ds.getUserRoleMap().put(du, DrailUserRole.PRODUCT_OWNER);
		return repo.save(ds);
	}

}
