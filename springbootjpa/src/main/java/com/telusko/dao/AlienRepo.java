package com.telusko.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telusko.modal.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

//	List<Alien> findByTech(String tech);
//	List<Alien> findByidGreaterThan(int id);
//	
//	@Query("from Alien where tech = ?1 order by name")
//	List <Alien> findByTechSorted(String tech);
//	
	
}
