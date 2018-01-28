package com.revature.drail.dto;

import java.util.ArrayList;
import java.util.List;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailTile;

public class DrailRailDTO implements Comparable {
	
	private int railId;
	private String name;
	private int order;
	private int stationId;
	private List<Integer> tileIds = new ArrayList<>();
	
	public DrailRailDTO() {
	}
	
	public DrailRailDTO(DrailRail rail) {
		this.railId = rail.getRailId();
		this.name = rail.getName();
		this.order = rail.getOrder();
		if (rail.getStation() != null) this.stationId = rail.getStation().getStationId();
		if (rail.getTiles() != null) {
			for(DrailTile tile : rail.getTiles()) {
				tileIds.add(tile.getTileId());
			}
		}
	}

	public DrailRailDTO(int railId, String name, int order, int stationId, List<Integer> tileIds) {
		super();
		this.railId = railId;
		this.name = name;
		this.order = order;
		this.stationId = stationId;
		this.tileIds = tileIds;
	}

	public int getRailId() {
		return railId;
	}

	public void setRailId(int railId) {
		this.railId = railId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public List<Integer> getTileIds() {
		return tileIds;
	}

	public void setTileIds(List<Integer> tileIds) {
		this.tileIds = tileIds;
	}

	@Override
	public String toString() {
		return "DrailRailDTO [railId=" + railId + ", name=" + name + ", order=" + order + ", stationId=" + stationId
				+ ", tileIds=" + tileIds + "]";
	}

	@Override
	public int compareTo(Object o) {
		return (this.order - ((DrailRailDTO) o).getOrder());
	}
	
}
