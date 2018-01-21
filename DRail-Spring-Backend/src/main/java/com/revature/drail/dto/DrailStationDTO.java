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
	private List<DrailRail> rails = new ArrayList<>();
	private List<DrailUserDTO> users = new ArrayList<>();
	
	public DrailStationDTO() {
	}
	
	public DrailStationDTO(DrailStation station) {
		this.stationId = station.getStationId();
		this.name = station.getName();
		this.timeCreated = station.getTimeCreated();
		this.dueDate = station.getDueDate();
		this.rails = station.getRails();
		for(DrailUser user : station.getUsers()) {
			users.add(new DrailUserDTO(user));
		}
	}
	
	

	public DrailStationDTO(int stationId, String name, Timestamp timeCreated, Date dueDate, List<DrailRail> rails,
			List<DrailUserDTO> users) {
		this.stationId = stationId;
		this.name = name;
		this.timeCreated = timeCreated;
		this.dueDate = dueDate;
		this.rails = rails;
		this.users = users;
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

	public List<DrailRail> getRails() {
		return rails;
	}

	public void setRails(List<DrailRail> rails) {
		this.rails = rails;
	}

	public List<DrailUserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<DrailUserDTO> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "DrailStationDTO [stationId=" + stationId + ", name=" + name + ", timeCreated=" + timeCreated
				+ ", dueDate=" + dueDate + ", rails=" + rails + ", users=" + users + "]";
	}
	
	
	
	
}
