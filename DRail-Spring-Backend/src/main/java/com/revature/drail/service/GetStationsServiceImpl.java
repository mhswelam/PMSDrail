package com.revature.drail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;
import com.revature.drail.dto.DrailStationViewDTO;
import com.revature.drail.dto.DrailStationsDTO;
import com.revature.drail.repo.DrailStationRepo;

@Service
public class GetStationsServiceImpl implements GetStationsService {

	@Autowired
	DrailStationRepo repo;
	
	@Override
	public DrailStationsDTO getStations(DrailUser du){
		Map<DrailStation,DrailUserRole> userStMap = du.getStationRoleMap();
		List<DrailStationViewDTO> allUserStations = new ArrayList<>();
		
		for(DrailStation ds: userStMap.keySet()) {
			allUserStations.add(new DrailStationViewDTO(ds));
		}
		
		DrailStationsDTO drailStations = new DrailStationsDTO();
		drailStations.setStations(allUserStations);
		return  drailStations;
	};
}


