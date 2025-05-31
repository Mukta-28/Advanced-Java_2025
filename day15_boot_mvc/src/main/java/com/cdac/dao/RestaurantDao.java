package com.cdac.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant,Long>{
//get restaurant details by its name-derived method
	//JPQL - select r from Restaurant r where r.name=:name
	//ret empty optional in case name not found or returns optional containing
	Optional<Restaurant> findByName(String restaurantName);
	//find all available restaurants-derived query method
	//select r from Restaurant r where r.status=true
	List<Restaurant> findByStatusTrue();
	
}
