package com.revature.drail.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailChartDTO;
import com.revature.drail.dto.DrailChartOutDTO;
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
		if (currentSt.getRails() == null && currentSt.getRails().isEmpty()) {
			return sendOut;
		}
		
		for (DrailRail rails: currentSt.getRails()) {
			tileList.addAll(rails.getTiles());
		}
		
		List<DrailTile> completedTiles = new ArrayList<>();
		int totalpoints = 0;
		int leftPoints = 0;
		for (DrailTile aTile : tileList ) {
			totalpoints += aTile.getPoints();
			if (aTile.getCompleted() == 1) {
				completedTiles.add(aTile);
			} 
		}
		sendOut.setPoints(totalpoints);
		if (completedTiles.isEmpty()) {
			return sendOut;
		}
		Collections.sort(completedTiles, new DrailTileByDate()); 
		
		leftPoints = totalpoints;
		
		sendOut.setData(new ArrayList<>());
		leftPoints = leftPoints - completedTiles.get(0).getPoints();
		int dataIndex = 0;
		sendOut.getData().add(dataIndex, leftPoints);
		
		for (int i = 1; i < completedTiles.size(); i++) {
			if ((completedTiles.get(i).getDateCompleted().toLocalDate()).isEqual((completedTiles.get(i-1).getDateCompleted().toLocalDate()))){
				leftPoints = leftPoints - completedTiles.get(i).getPoints();
				sendOut.getData().set(dataIndex, leftPoints);
			} else {
				dataIndex++;
				leftPoints = leftPoints - completedTiles.get(i).getPoints();
				sendOut.getData().add(leftPoints);
			}
		}
		
		
		LocalDate due = currentSt.getDueDate().toLocalDate();
		LocalDate start = currentSt.getTimeCreated().toLocalDate();
		
		List<Integer> labels = new ArrayList<>();
		for(LocalDate i = start; i.isBefore(due.plusDays(1)); i = i.plusDays(1)) {
			labels.add(i.getDayOfMonth());
		}
		
		for (int i = sendOut.getData().size(); i < labels.size(); i++) {
			sendOut.getData().add(leftPoints);
		}
		
		sendOut.setLabels(labels);
		
		return sendOut;
	}

}
