package com.revature.drail.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DRAIL_ROLES")
public enum DrailUserRole {
	
	PRODUCT_OWNER(64),
	SCRUM_MASTER(27),
	TEAM_MEMBER(652);
	
	@Id
	@Column(name="ROLE_ID")
	private int id;
	
	private DrailUserRole(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	
}
