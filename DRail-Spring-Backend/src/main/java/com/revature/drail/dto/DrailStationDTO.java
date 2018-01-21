package com.revature.drail.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;

public class DrailStationDTO {

	private int stationId;
	private String name;
	private Timestamp timeCreated;
	private Date dueDate;
	private List<Integer> railIds = new ArrayList<>();
	private List<Integer> userIds = new ArrayList<>();
	
	public DrailStationDTO() {
	}
	
	public DrailStationDTO(DrailStation station) {
		this.stationId = station.getStationId();
		this.name = station.getName();
		this.timeCreated = station.getTimeCreated();
		this.dueDate = station.getDueDate();
		if (station.getRails() != null) {
			for(DrailRail rail : station.getRails()) {
				this.railIds.add(rail.getRailId());
			}
		}
		if (station.getUsers() != null) {
			for(DrailUser user : station.getUsers()) {
				this.userIds.add(user.getUserId());
			}
		}
	}

	public DrailStationDTO(int stationId, String name, Timestamp timeCreated, Date dueDate, List<Integer> railIds,
			List<Integer> userIds) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.timeCreated = timeCreated;
		this.dueDate = dueDate;
		this.railIds = railIds;
		this.userIds = userIds;
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

	public Timestamp getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<Integer> getRailIds() {
		return railIds;
	}

	public void setRailIds(List<Integer> railIds) {
		this.railIds = railIds;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		return "DrailStationDTO [stationId=" + stationId + ", name=" + name + ", timeCreated=" + timeCreated
				+ ", dueDate=" + dueDate + ", railIds=" + railIds + ", userIds=" + userIds + "]";
	}

}
