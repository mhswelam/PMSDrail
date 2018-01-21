//package com.revature.drail.repo;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
////@Repository
////public class DRailURSRepoImpl implements DRailURSRepo{
////
//////	@Override
//////	public void modifyURS(int roleId, int userId, int stationId) {
//////		
//////		Session session = sessionFactory.openSession();
//////		Transaction tx = session.beginTransaction();
//////		String updateRole = "UPDATE drail_urs urs set urs.urs_r_id = :newRole where urs.urs_u_id = :uId "
//////				+ "AND urs.urs_s_id = :sId";
////		
////	}
//
//}
