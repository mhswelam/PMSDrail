package com.revature.drail.service;

import com.revature.drail.dto.DrailUserDTO;

public interface GetUserService {

	public DrailUserDTO getUserByUsername(String username);
}
