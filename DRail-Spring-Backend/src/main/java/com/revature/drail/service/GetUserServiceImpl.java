package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.repo.DrailUserRepo;

@Service
public class GetUserServiceImpl implements GetUserService{

	@Autowired
	DrailUserRepo repo;
	
	@Override
	public DrailUserDTO getUserByUsername(String username) {
		return new DrailUserDTO(repo.findByUsername(username));
	}

}
