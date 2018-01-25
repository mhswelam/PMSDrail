package com.revature.drail.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DRAIL_ROLES")
public class DrailUserRole {
	

	public static final transient DrailUserRole PRODUCT_OWNER = new DrailUserRole(64, "PRODUCT OWNER");
	
	public static final transient DrailUserRole SCRUM_MASTER = new DrailUserRole(27, "SCRUM MASTER");
	
	public static final transient DrailUserRole TEAM_MEMBER = new DrailUserRole(652, "TEAM MEMBER");;
	
	@Id
	@Column(name="ROLE_ID")
	private int id;
	
	@Column(name="ROLE_NAME")
	private String name;
	
	
	
	public DrailUserRole() {
		
	}


	

	public DrailUserRole(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
