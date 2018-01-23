package com.revature.drail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.drail.beans.DrailRail;


public interface DrailRailRepo extends JpaRepository<DrailRail, Integer> {
	

}
