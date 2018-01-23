package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.dto.DrailRailDTO;
import com.revature.drail.repo.DrailRailRepo;

@Service
public class UpdateRailServiceImpl implements UpdateRailService {
	
	@Autowired
	DrailRailRepo railRepo;

	@Override
	public void updateRail(DrailRailDTO railDTO) {
		DrailRail rail = new DrailRail();
		rail.setRailId(railDTO.getRailId());
		rail.setName(railDTO.getName());
		rail.setOrder(railDTO.getOrder());
		rail.setStation(new DrailStation(railDTO.getStationId()));
		railRepo.save(rail);
	}

}
