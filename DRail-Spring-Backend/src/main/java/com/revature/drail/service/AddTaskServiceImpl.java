package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailTaskDTO;
import com.revature.drail.repo.DrailTaskRepo;

@Service
public class AddTaskServiceImpl implements AddTaskService {
	
	@Autowired
	private DrailTaskRepo taskRepo;
	
	public void saveTask(DrailTaskDTO taskDTO) {
		DrailTask task = new DrailTask();
		task.setTaskId(taskDTO.getTaskId());
		task.setName(taskDTO.getName());
		task.setCompleted(taskDTO.isCompleted() ? 1 : 0);
		task.setOrder(taskDTO.getOrder());
		DrailTile tile = new DrailTile();
		tile.setTileId(taskDTO.getTileId());
		task.setTile(tile);
		taskRepo.save(task);
	}


}
