package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.repo.DrailUserRepo;

@Service
public class GetUserByUsernameImpl implements GetUserByUsernameService{
	
	@Autowired
	DrailUserRepo repo;

	@Override
	public DrailUser getUserByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	
}
