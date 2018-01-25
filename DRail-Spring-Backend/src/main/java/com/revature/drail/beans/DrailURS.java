package com.revature.drail.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="DRAIL_URS")
public class DrailURS {

	@Id
	@Column(name="URS_ID")
	private int id;
	
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	@MapKeyJoinColumn
	@JoinColumn(name="URS_U_ID")
	private DrailUser user;
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	@JoinColumn(name="URS_S_ID")
	private DrailStation station;
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	@JoinColumn(name="URS_R_ID")
	private DrailUserRole role;
	
	
	
	public DrailURS() {
	}
	
	public DrailURS(int id, DrailUser user, DrailStation station, DrailUserRole role) {
		super();
		this.id = id;
		this.user = user;
		this.station = station;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DrailUser getUser() {
		return user;
	}
	public void setUser(DrailUser user) {
		this.user = user;
	}
	public DrailStation getStation() {
		return station;
	}
	public void setStation(DrailStation station) {
		this.station = station;
	}
	public DrailUserRole getRole() {
		return role;
	}
	public void setRole(DrailUserRole role) {
		this.role = role;
	}
}
