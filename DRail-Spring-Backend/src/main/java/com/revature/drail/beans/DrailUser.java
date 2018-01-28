package com.revature.drail.beans;

import java.util.HashMap;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

import com.revature.drail.dto.DrailUserDTO;

@Entity
@Table(name="DRAIL_USERS")
public class DrailUser {
	
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="USERS_SEQ", sequenceName="USERS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_SEQ")
	private int userId;
	
	@Column(name="USER_NAME")
	private String username;
	
	@Column(name="USER_PASS")
	private String password;
	
	@Column(name="USER_FIRST")
	private String firstname;
	
	@Column(name="USER_LAST")
	private String lastname;
	
	@Column(name="USER_EMAIL")
	private String email;
	
//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinTable(name = "DRAIL_URS",
//			joinColumns= { @JoinColumn(name="URS_U_ID") },
//			inverseJoinColumns= {@JoinColumn(name="URS_S_ID") })
//	 private Set<DrailStation> stations = new HashSet<>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="DRAIL_URS",
		joinColumns=@JoinColumn(name="URS_U_ID"),
		inverseJoinColumns=@JoinColumn(name="URS_R_ID"))
	@MapKeyJoinColumn(name="URS_S_ID")
	Map<DrailStation, DrailUserRole> stationRoleMap = new HashMap<>();
	
	public DrailUser() {
	}

	
	public DrailUser(int userId) {
		super();
		this.userId = userId;
	}


	public DrailUser(DrailUserDTO dtoUser) {
		super();
		this.setUsername(dtoUser.getUsername());
		this.setPassword(dtoUser.getPassword());
		this.setFirstname(dtoUser.getFirstname());
		this.setLastname(dtoUser.getLastname());
		this.setEmail(dtoUser.getEmail());
	}


	public DrailUser(String username, String password, String firstname, String lastname, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	@Required
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}

	@Required
	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	@Required
	public void setPassword(String password) {
		this.password = password;
	}

	@Required
	public String getFirstname() {
		return firstname;
	}

	@Required
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}

	@Required
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}

	@Required
	public void setEmail(String email) {
		this.email = email;
	}


	public Map<DrailStation, DrailUserRole> getStationRoleMap() {
		return stationRoleMap;
	}


	public void setStationRoleMap(Map<DrailStation, DrailUserRole> stationRoleMap) {
		this.stationRoleMap = stationRoleMap;
	}


	@Override
	public String toString() {
		return "DrailUser [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
}
