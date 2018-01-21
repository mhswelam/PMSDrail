package com.revature.drail.service;

import com.revature.drail.beans.DrailUser;
import com.revature.drail.dto.DrailUserDTO;

public interface LoginService {
	
	public DrailUser login(DrailUser du);

}
