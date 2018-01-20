package com.revature.drail.beans;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	private Timestamp timeCreated;

	@Column(name = "ST_DUE")
	private Date dueDate;

	@ManyToMany
	@JoinTable(name = "DRAIL_URS",
			joinColumns= { @JoinColumn(name="URS_S_ID") },
			inverseJoinColumns= {@JoinColumn(name="URS_U_ID") })
	Set<DrailUser> users = new HashSet<>();
	
	public DrailStation() {
		super();
	}

	public DrailStation(int stationId, String name, Timestamp timeCreated, Date dueDate) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.timeCreated = timeCreated;
		this.dueDate = dueDate;
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
	
	public Set<DrailUser> getUsers() {
		return users;
	}

	public void setUsers(Set<DrailUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "DrailStation [stationId=" + stationId + ", name=" + name + ", timeCreated=" + timeCreated + ", dueDate="
				+ dueDate + "]";
	}
}