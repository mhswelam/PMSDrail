package com.revature.drail.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;


@Entity
@Table(name = "DRAIL_ST")
public class DrailStation {

	@Id
	@Column(name = "ST_ID")
	@SequenceGenerator(name="S_SEQ", sequenceName="S_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_SEQ")
	private int stationId;

	@Column(name = "ST_NAME")
	private String name;

	@Column(name = "ST_CREATED")
	private Date timeCreated;

	@Column(name = "ST_DUE")
	private Date dueDate;

//	@ManyToMany
//	@JoinTable(name = "DRAIL_URS",
//			joinColumns= { @JoinColumn(name="URS_S_ID") },
//			inverseJoinColumns= {@JoinColumn(name="URS_U_ID") })
//	private List<DrailUser> users = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="DRAIL_URS",
		joinColumns=@JoinColumn(name="URS_S_ID"),
		inverseJoinColumns=@JoinColumn(name="URS_R_ID"))
	@MapKeyJoinColumn(name="URS_U_ID")
	Map<DrailUser, DrailUserRole> userRoleMap = new HashMap<>();
	
	@OneToMany(mappedBy="station", fetch=FetchType.EAGER)
	private List<DrailRail> rails = new ArrayList<>();
	
	public DrailStation() {
		super();
	}

	
	public DrailStation(int stationId) {
		super();
		this.stationId = stationId;
	}


	public DrailStation(int stationId, String name, Date timeCreated, Date dueDate,
			Map<DrailUser, DrailUserRole> userRoleMap, List<DrailRail> rails) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.timeCreated = timeCreated;
		this.dueDate = dueDate;
		this.userRoleMap = userRoleMap;
		this.rails = rails;
	}


	public int getStationId() {
		return stationId;
	}

	@Required
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}


	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}


	public Date getTimeCreated() {
		return timeCreated;
	}


	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}


	public Date getDueDate() {
		return dueDate;
	}

	@Required
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Map<DrailUser, DrailUserRole> getUserRoleMap() {
		return userRoleMap;
	}


	public void setUserRoleMap(Map<DrailUser, DrailUserRole> userRoleMap) {
		this.userRoleMap = userRoleMap;
	}


	public List<DrailRail> getRails() {
		return rails;
	}


	public void setRails(List<DrailRail> rails) {
		this.rails = rails;
	}


	@Override
	public String toString() {
		return "DrailStation [stationId=" + stationId + ", name=" + name + ", timeCreated=" + timeCreated + ", dueDate="
				+ dueDate + ", userRoleMap=" + userRoleMap.entrySet() + ", rails=" + rails.size() + "]";
	}


}