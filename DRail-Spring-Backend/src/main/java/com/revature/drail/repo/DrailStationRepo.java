package com.revature.drail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.drail.beans.DrailStation;

public interface DrailStationRepo extends JpaRepository<DrailStation, Integer>{

}
