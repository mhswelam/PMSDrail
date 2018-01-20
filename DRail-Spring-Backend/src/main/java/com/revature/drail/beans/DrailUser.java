package com.revature.drail.beans;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "DRAIL_URS",
			joinColumns= { @JoinColumn(name="URS_U_ID") },
			inverseJoinColumns= {@JoinColumn(name="URS_S_ID") })
	Set<DrailStation> stations = new HashSet<>();
	
	public DrailUser() {
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
	
	public Set<DrailStation> getStations() {
		return stations;
	}

	public void setStations(Set<DrailStation> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "DrailUser [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
}
