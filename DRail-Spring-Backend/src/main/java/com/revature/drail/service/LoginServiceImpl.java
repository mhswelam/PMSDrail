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
	public DrailUserDTO login(DrailUser du) {
		DrailUserDTO result = new DrailUserDTO();
		DrailUser user = userRepo.findByUsername(du.getUsername());
		if (user != null && user.getPassword().equals(du.getPassword())) {
			result = new DrailUserDTO(user);
		}
		return result;
	}

}
