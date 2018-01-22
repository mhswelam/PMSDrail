package com.revature.drail.dto;

import java.util.HashMap;
import java.util.Map;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;

public class DrailUserDTO{
	
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Map<Integer, DrailUserRole> stationRoleMap = new HashMap<>();
	
	public DrailUserDTO() {
	}

	public DrailUserDTO(int userId, String username, String firstname, String lastname, String email) {
		this.userId = userId;
		this.username = username;
		this.password = "";
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public DrailUserDTO(DrailUser user) {
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.password = "";
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.email = user.getEmail();
		if (user.getStationRoleMap() != null) {
			for(DrailStation station : user.getStationRoleMap().keySet()) {
				DrailUserRole role = user.getStationRoleMap().get(station);
				this.stationRoleMap.put(station.getStationId(), user.getStationRoleMap().get(station));
			}
		}
	}

	public DrailUserDTO(int userId, String username, String password, String firstname, String lastname, String email,
			Map<Integer, DrailUserRole> stationRoleMap) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.stationRoleMap = stationRoleMap;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<Integer, DrailUserRole> getStationRoleMap() {
		return stationRoleMap;
	}

	public void setStationRoleMap(Map<Integer, DrailUserRole> stationRoleMap) {
		this.stationRoleMap = stationRoleMap;
	}

	@Override
	public String toString() {
		return "DrailUserDTO [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", stationRoleMap=" + stationRoleMap
				+ "]";
	}

}
