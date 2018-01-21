package com.revature.drail.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.revature.drail.beans.DrailStation;
import com.revature.drail.beans.DrailURS;
import com.revature.drail.beans.DrailUser;
import com.revature.drail.beans.DrailUserRole;

public interface DRailURSRepo extends JpaRepository<DrailURS, Integer>{
	
	@Modifying
	@Query("UPDATE DrailURS set role = ?1 where user = ?2 AND station = ?3")
	@Transactional
	public void modifyURS(DrailUserRole role,DrailUser user,DrailStation station);
}	
 