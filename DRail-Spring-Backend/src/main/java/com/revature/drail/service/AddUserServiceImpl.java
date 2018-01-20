package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.repo.DrailUserRepo;

@Service
public class AddUserServiceImpl implements AddUserService{

	@Autowired
	DrailUserRepo repo;
	
	public void addUser(DrailUser du) {
		du = repo.save(du);
	}
}
