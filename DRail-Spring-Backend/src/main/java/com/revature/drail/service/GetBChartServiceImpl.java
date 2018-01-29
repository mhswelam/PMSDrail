package com.revature.drail.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailChartDTO;
import com.revature.drail.dto.DrailChartOutDTO;
import com.revature.drail.dto.OrderedPair;
import com.revature.drail.util.DrailTileByDate;

@Service
public class GetBChartServiceImpl implements GetBChartService {

	
	@Autowired
	ViewTileServiceImpl tileSer;
	@Autowired
	ViewStationServiceImpl stSer;
	
	
	
	@Override
	public DrailChartOutDTO getChartDto(DrailChartDTO chartDto) {
		
		
		DrailChartOutDTO sendOut = new DrailChartOutDTO();
		DrailStation currentSt = stSer.viewStationById(chartDto.getStId());
		List<DrailTile> tileList = new ArrayList<>();
		for (DrailRail rails: currentSt.getRails()) {
			tileList.addAll(rails.getTiles());
		}
		Date due = currentSt.getDueDate();
		sendOut.setData(new ArrayList<>());
		
		List<DrailTile> completedTiles = new ArrayList<>();
		List<DrailTile> notComplTiles = new ArrayList<>();
		int totalpoints = 0;
		int leftPoints = 0;
		
		for (DrailTile aTile : tileList ) {
			totalpoints += aTile.getPoints();
			if (aTile.getCompleted() == 1) {
				completedTiles.add(aTile);
			} else {
				notComplTiles.add(aTile);
			}
			
		}
		Collections.sort(completedTiles, new DrailTileByDate()); 
		leftPoints = totalpoints;
		for(DrailTile aTile : completedTiles) {
			leftPoints = leftPoints - aTile.getPoints();
			sendOut.getData().add(new OrderedPair(aTile.getDateCompleted().getTime(), leftPoints));
		}
		
		for(int i = 0 ; i < notComplTiles.size(); i++) {
			sendOut.getData().add(new OrderedPair(0L, leftPoints));
		}
		
		
		
		return sendOut;
	}

}
