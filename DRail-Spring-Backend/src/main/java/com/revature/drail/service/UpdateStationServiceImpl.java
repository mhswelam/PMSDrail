package com.revature.drail.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;
import com.revature.drail.dto.DrailStationDTO;
import com.revature.drail.repo.DrailRailRepo;
import com.revature.drail.repo.DrailStationRepo;
import com.revature.drail.repo.DrailUserRepo;


@Service
public class UpdateStationServiceImpl implements UpdateStationService {

	@Autowired
	DrailUserRepo userRepo;
	@Autowired
	DrailRailRepo drailRailRepo;
	@Autowired
	DrailStationRepo drailStationRepo;
	
	@Override
	public void updateStation(DrailStationDTO updatedStation) {
		
			DrailStation station = new DrailStation();
			station.setStationId(updatedStation.getStationId());
			station.setDueDate(updatedStation.getDueDate());
			station.setName(updatedStation.getName());
			station.setTimeCreated(updatedStation.getTimeCreated());
			List<DrailRail> rails = station.getRails();
			Map<DrailUser,DrailUserRole> userRoleMap = station.getUserRoleMap();

//			for(int n : updatedStation.getRailIds()) {
//				rails.add(new DrailRail(n));
//			}
			
			for(int n : updatedStation.getUserRoleMap().keySet()) {
				DrailUser user = new DrailUser(n);
//				DrailUser user = userRepo.getOne(n);
				DrailUserRole role = updatedStation.getUserRoleMap().get(n);
				userRoleMap.put(user, role);
			}
			drailStationRepo.save(station);	
	}

}
