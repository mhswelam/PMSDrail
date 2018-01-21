package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.repo.DrailUserRepo;


@Service
public class UpdateUserServiceImpl implements UpdateUserService {
	
	
	@Autowired
	DrailUserRepo repo;

	@Override
	public void updateUser(DrailUser du) {
		repo.save(du);

	}

}
