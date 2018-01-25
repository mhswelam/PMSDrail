package com.revature.drail.service;

import com.revature.drail.dto.DrailTaskDTO;

public interface AddTaskService {
	
	/**
	 * Converts [task] to a DrailTask and persists it to the database
	 * @param task Should contain all information needed to create a DrailTask and the DrailTile id of this task's parent tile
	 */
	public void saveTask(DrailTaskDTO task);

}
