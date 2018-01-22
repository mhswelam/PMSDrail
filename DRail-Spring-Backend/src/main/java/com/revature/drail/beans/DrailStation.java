package com.revature.drail.beans;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	private List<DrailUser> users = new ArrayList<>();
	
	@OneToMany(mappedBy="station", fetch=FetchType.EAGER)
	private List<DrailRail> rails = new ArrayList<>();
	
	public DrailStation() {
		super();
	}

	
	public DrailStation(int stationId) {
		super();
		this.stationId = stationId;
	}


	public DrailStation(int stationId, String name, Timestamp timeCreated, Date dueDate, List<DrailUser> users,
			List<DrailRail> rails) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.timeCreated = timeCreated;
		this.dueDate = dueDate;
		this.users = users;
		this.rails = rails;
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

	public List<DrailUser> getUsers() {
		return users;
	}

	public void setUsers(List<DrailUser> users) {
		this.users = users;
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
				+ dueDate + ", users=" + users + ", rails=" + rails + "]";
	}

}