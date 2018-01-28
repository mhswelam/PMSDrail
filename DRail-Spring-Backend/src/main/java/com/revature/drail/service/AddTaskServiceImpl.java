package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.dto.DrailTaskDTO;
import com.revature.drail.repo.DrailTaskRepo;
import com.revature.drail.repo.DrailTileRepo;

@Service
public class AddTaskServiceImpl implements AddTaskService {
	
	@Autowired
	private DrailTaskRepo taskRepo;
	
	@Autowired
	private DrailTileRepo tileRepo;
	
	public boolean  saveTask(DrailTaskDTO taskDTO) {
		System.out.println(taskDTO);
		DrailTask task = new DrailTask();
		task.setTaskId(taskDTO.getTaskId());
		task.setName(taskDTO.getName());
		task.setCompleted(taskDTO.isCompleted() ? 1 : 0);
		task.setOrder(taskDTO.getOrder());
		task.setTile(tileRepo.findOne(taskDTO.getTileId()));
		if (taskRepo.save(task) != null ) {
			return true;
		} else {
			return false;
		}
	}


}
