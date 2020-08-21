package com.revature.drail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.drail.beans.DrailTask;

public interface DrailTaskRepo extends JpaRepository<DrailTask, Integer>{

}
