package com.revature.drail.beans;

import java.security.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DRAIL_TILE")
public class DrailTile {
	
	@Id
	@SequenceGenerator(name="TILE_SEQ", sequenceName="TILE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TILE_SEQ")
	@Column(name="TILE_ID")
	private int tileId;
	
	@Column(name="TILE_NAME")
	private String name;
	
	@Column(name="TILE_POINTS")
	private int points;
	
	@Column(name="TILE_NOTE")
	private String note;
	
	@Column(name="TILE_DATE_COMPLETED")
	private Timestamp dateCompleted;
	
	@Column(name="TILE_COMPLETED")
	private int completed;
	
	@Column(name="TILE_ORDER")
	private int order;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private DrailUser userCheckedOut;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="RAIL_ID")
	private DrailRail rail;
	
	@OneToMany(mappedBy="tile", fetch=FetchType.EAGER)
	private DrailTask task;
	
	public DrailTile() {
	}

	public DrailTile(int tileId, String name, int points, String note, Timestamp dateCompleted, int completed,
			int order, DrailUser userCheckedOut, DrailRail rail, DrailTask task) {
		super();
		this.tileId = tileId;
		this.name = name;
		this.points = points;
		this.note = note;
		this.dateCompleted = dateCompleted;
		this.completed = completed;
		this.order = order;
		this.userCheckedOut = userCheckedOut;
		this.rail = rail;
		this.task = task;
	}

	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Timestamp dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public DrailUser getUserCheckedOut() {
		return userCheckedOut;
	}

	public void setUserCheckedOut(DrailUser userCheckedOut) {
		this.userCheckedOut = userCheckedOut;
	}

	public DrailRail getRail() {
		return rail;
	}

	public void setRail(DrailRail rail) {
		this.rail = rail;
	}

	public DrailTask getTask() {
		return task;
	}

	public void setTask(DrailTask task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "DrailTile [tileId=" + tileId + ", name=" + name + ", points=" + points + ", note=" + note
				+ ", dateCompleted=" + dateCompleted + ", completed=" + completed + ", order=" + order
				+ ", userCheckedOut=" + userCheckedOut + ", rail=" + rail + ", task=" + task + "]";
	}

}
