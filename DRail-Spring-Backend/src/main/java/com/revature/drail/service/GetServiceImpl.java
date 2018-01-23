package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailTask;
import com.revature.drail.beans.DrailTile;
import com.revature.drail.repo.DrailTaskRepo;
import com.revature.drail.repo.DrailTileRepo;

@Service
public class GetServiceImpl implements GetService {
	
	@Autowired
	DrailTileRepo tileRepo;
	@Autowired
	DrailTaskRepo taskRepo;

	@Override
	public DrailTile getTileById(int tileId) {
		return tileRepo.findOne(tileId);
	}

	@Override
	public DrailTask getTaskById(int taskId) {
		return taskRepo.findOne(taskId);
	}

}
