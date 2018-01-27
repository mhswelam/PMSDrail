package com.revature.drail.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.beans.DrailTile;

public class DrailTileDTO implements Comparable {

	private int tileId;
	private String name;
	private int points;
	private String note;
	private Date dateCompleted;
	private boolean completed;
	private int order;
	private int userCheckedOutId;
	private int railId;
	private List<Integer> taskIds = new ArrayList<Integer>();
	
	public DrailTileDTO() {
	}
	
	public DrailTileDTO(DrailTile tile) {
		this.tileId = tile.getTileId();
		this.name = tile.getName();
		this.points = tile.getPoints();
		this.note = tile.getNote();
		this.dateCompleted = tile.getDateCompleted();
		this.completed = (tile.getCompleted() == 0) ? false : true;
		this.order = tile.getOrder();
		if (tile.getUserCheckedOut() != null) this.userCheckedOutId = tile.getUserCheckedOut().getUserId();
		if (tile.getRail() != null) this.railId = tile.getRail().getRailId();
		if (tile.getTask() != null) {
			for(DrailTask task : tile.getTask()) {
				taskIds.add(task.getTaskId());
			}
		}
	}

	public DrailTileDTO(int tileId, String name, int points, String note, Date dateCompleted, boolean completed,
			int order, int userCheckedOutId, int railId, List<Integer> taskIds) {
		super();
		this.tileId = tileId;
		this.name = name;
		this.points = points;
		this.note = note;
		this.dateCompleted = dateCompleted;
		this.completed = completed;
		this.order = order;
		this.userCheckedOutId = userCheckedOutId;
		this.railId = railId;
		this.taskIds = taskIds;
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

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getUserCheckedOutId() {
		return userCheckedOutId;
	}

	public void setUserCheckedOutId(int userCheckedOutId) {
		this.userCheckedOutId = userCheckedOutId;
	}

	public int getRailId() {
		return railId;
	}

	public void setRailId(int railId) {
		this.railId = railId;
	}

	public List<Integer> getTaskIds() {
		return taskIds;
	}

	public void setTaskIds(List<Integer> taskIds) {
		this.taskIds = taskIds;
	}

	@Override
	public String toString() {
		return "DrailTileDTO [tileId=" + tileId + ", name=" + name + ", points=" + points + ", note=" + note
				+ ", dateCompleted=" + dateCompleted + ", completed=" + completed + ", order=" + order
				+ ", userCheckedOutId=" + userCheckedOutId + ", railId=" + railId + ", taskIds=" + taskIds + "]";
	}

	@Override
	public int compareTo(Object other) {
		return (this.order - ((DrailTileDTO) other).getOrder());
	}
	
}
