package com.revature.drail.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DRAIL_TASK")
public class DrailTask {
	
	@Id
	@SequenceGenerator(name="TASK_SEQ", sequenceName="TASK_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASK_SEQ")
	@Column(name="TASK_ID")
	private int taskId;
	
	@Column(name="TASK_NAME")
	private String name;
	
	@Column(name="TASK_COMPLETED")
	private int completed;
	
	@Column(name="TASK_ORDER")
	private int order;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)

	@JoinColumn(name="TASK_T_ID")
	private DrailTile tile;
	
	public DrailTask() {
	}

	public DrailTask(int taskId, String name, int completed, int order, DrailTile tile) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.completed = completed;
		this.order = order;
		this.tile = tile;
	}

	public int getTaskId() {
		return taskId;
	}
	@Required
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
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
	@Required
	public void setOrder(int order) {
		this.order = order;
	}

	public DrailTile getTile() {
		return tile;
	}
	@Required
	public void setTile(DrailTile tile) {
		this.tile = tile;
	}

	@Override
	public String toString() {
		return "DrailTask [taskId=" + taskId + ", name=" + name + ", completed=" + completed + ", order=" + order
				+ ", tile=" + tile + "]";
	}

}
