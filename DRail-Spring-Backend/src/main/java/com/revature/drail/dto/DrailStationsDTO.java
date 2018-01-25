package com.revature.drail.dto;

import java.util.List;

public class DrailStationsDTO {
	
	private List<DrailStationViewDTO> stations;
	
	public DrailStationsDTO() {
	}
	
	public DrailStationsDTO(List<DrailStationViewDTO> stations) {
		this.stations = stations;
	}

	public List<DrailStationViewDTO> getStations() {
		return stations;
	}

	public void setStations(List<DrailStationViewDTO> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "DrailStationsDTO [stations=" + stations + "]";
	}
	
}
