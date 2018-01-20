package com.revature.drail.beans;

public enum DrailUserRole {
	
	PRODUCT_OWNER(64),
	SCRUM_MASTER(27),
	TEAM_MEMBER(652);
	
	private int id;
	
	private DrailUserRole(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	
}
