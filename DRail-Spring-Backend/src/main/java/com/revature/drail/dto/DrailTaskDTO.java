package com.revature.drail.dto;

import com.revature.drail.beans.DrailTask;

public class DrailTaskDTO {

	private int taskId;
	private String name;
	private boolean completed;
	private int order;
	private int tileId;
	
	public DrailTaskDTO() {
	}
	
	public DrailTaskDTO(DrailTask task) {
		this.taskId = task.getTaskId();
		this.name = task.getName();
		this.completed = (task.getCompleted() == 0) ? true : false;
		this.order = task.getOrder();
		if (task.getTile() != null) this.tileId = task.getTile().getTileId();
	}

	public DrailTaskDTO(int taskId, String name, boolean completed, int order, int tileId) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.completed = completed;
		this.order = order;
		this.tileId = tileId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}

	@Override
	public String toString() {
		return "DrailTaskDTO [taskId=" + taskId + ", name=" + name + ", completed=" + completed + ", order=" + order
				+ ", tileId=" + tileId + "]";
	}
	
}
