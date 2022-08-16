package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.UserTable;

public interface UserRepository extends JpaRepository<UserTable, Long>{
	
	//I added today
	@Query(
	        "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM UserTable s WHERE s.id = ?1")
	    Boolean
	    isPersonExitsById(Integer id);
	
	
	//I created this today
	@Override
	List<UserTable> findAll();

}
