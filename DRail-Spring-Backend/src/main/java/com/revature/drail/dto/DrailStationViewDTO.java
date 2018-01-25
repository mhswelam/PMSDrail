package com.revature.drail.dto;

import com.revature.drail.beans.DrailStation;

public class DrailStationViewDTO extends DrailStation {
	
	private int stationId;
	private String name;
	
	public DrailStationViewDTO() {
	}

	public DrailStationViewDTO(int stationId, String name) {
		super();
		this.stationId = stationId;
		this.name = name;
	}
	
	public DrailStationViewDTO(DrailStation station) {
		this.stationId = station.getStationId();
		this.name = station.getName();
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DrailStationViewDTO [stationId=" + stationId + ", name=" + name + "]";
	}

}
