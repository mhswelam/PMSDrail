package com.revature.drail.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;

public class DrailStationDTO {

	private int stationId;
	private String name;
	private Timestamp timeCreated;
	private Date dueDate;
	private List<Integer> railIds = new ArrayList<>();
//	private List<Integer> userIds = new ArrayList<>();
	private Map<Integer, DrailUserRole> userRoleMap = new HashMap<>();
	
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
		if (station.getUserRoleMap().keySet() != null) {
			for(DrailUser user : station.getUserRoleMap().keySet()) {
				this.userRoleMap.put(user.getUserId(), station.getUserRoleMap().get(user));
			}
		}
	}

	public DrailStationDTO(int stationId, String name, Timestamp timeCreated, Date dueDate, List<Integer> railIds,
			Map<Integer, DrailUserRole> userRoleMap) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.timeCreated = timeCreated;
		this.dueDate = dueDate;
		this.railIds = railIds;
		this.userRoleMap = userRoleMap;
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

	public Map<Integer, DrailUserRole> getUserRoleMap() {
		return userRoleMap;
	}

	public void setUserRoleMap(Map<Integer, DrailUserRole> userRoleMap) {
		this.userRoleMap = userRoleMap;
	}

	@Override
	public String toString() {
		return "DrailStationDTO [stationId=" + stationId + ", name=" + name + ", timeCreated=" + timeCreated
				+ ", dueDate=" + dueDate + ", railIds=" + railIds + ", userRoleMap=" + userRoleMap + "]";
	}

}
