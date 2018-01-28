package com.revature.drail.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailChartDTO;
import com.revature.drail.dto.OrderedPair;
import com.revature.drail.util.DrailTileByDate;

@Service
public class GetBChartServiceImpl implements GetBChartService {

	
	@Autowired
	ViewTileServiceImpl tileSer;
	@Autowired
	ViewStationServiceImpl stSer;
	
	
	
	@Override
	public DrailChartDTO<Long, Integer> getChartDto(DrailChartDTO<Long, Integer> chartDto) {
		
		
		DrailChartDTO<Long, Integer> sendOut = new DrailChartDTO<Long, Integer>();
		DrailStation currentSt = stSer.viewStationById(chartDto.getStId());
		Date due = currentSt.getDueDate();
		sendOut.setData(new ArrayList<>());
		List<Integer> tileList = chartDto.getTileIds();
		List<DrailTile> completedTiles = new ArrayList<>();
		List<DrailTile> notComplTiles = new ArrayList<>();
		int totalpoints = 0;
		int leftPoints = 0;
		
		for (Integer id : tileList ) {
			DrailTile tile = tileSer.viewTileById(id);
			totalpoints += tile.getPoints();
			if (tile.getCompleted() == 1) {
				completedTiles.add(tile);
			} else {
				notComplTiles.add(tile);
			}
			
		}
		Collections.sort(completedTiles, new DrailTileByDate()); 
		leftPoints = totalpoints;
		for(DrailTile aTile : completedTiles) {
			leftPoints = leftPoints - aTile.getPoints();
			sendOut.getData().add(new OrderedPair<Long, Integer>(aTile.getDateCompleted().getTime(), leftPoints));
		}
		
		for(int i = 0 ; i < notComplTiles.size(); i++) {
			sendOut.getData().add(new OrderedPair<Long, Integer>(0L, leftPoints));
		}
		
		sendOut.setTotalPoints(totalpoints);
		sendOut.setStId(chartDto.getStId());
		
		return sendOut;
	}

}
