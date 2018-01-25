package com.revature.drail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailUserDTO;
import com.revature.drail.repo.DrailUserRepo;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	DrailUserRepo userRepo;
	
	@Override
	public DrailUser login(DrailUserDTO du) {
		DrailUser result = new DrailUser();
		DrailUser user = userRepo.findByUsername(du.getUsername());
		if (user != null && user.getPassword().equals(du.getPassword())) {
			result = user;
		}
		return result;
	}

}
