package com.revature.drail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.drail.beans.DrailTile;

public interface DrailTileRepo extends JpaRepository<DrailTile, Integer> {

}
