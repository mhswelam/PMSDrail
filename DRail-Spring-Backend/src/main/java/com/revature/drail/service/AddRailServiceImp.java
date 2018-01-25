package com.revature.drail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailRailDTO;
import com.revature.drail.repo.DrailRailRepo;



@Service
public class AddRailServiceImp implements AddRailService {
	
	@Autowired
	DrailRailRepo repo;

	@Override
	public DrailRail addRail(DrailRailDTO railDTO) {
		DrailStation st = new DrailStation();
		st.setStationId(railDTO.getStationId());
		DrailRail created = new DrailRail();
		created.setName(railDTO.getName());
		created.setStation(st);
		created.setOrder(railDTO.getOrder());
		return repo.save(created);
	}
}
