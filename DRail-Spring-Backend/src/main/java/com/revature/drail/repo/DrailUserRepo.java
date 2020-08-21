package com.revature.drail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.drail.beans.DrailUser;

public interface DrailUserRepo extends JpaRepository<DrailUser, Integer>{

	public DrailUser findByUsername(String username);
	
	//public DrailUser findOne(String username);
}
