package com.cdac.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Restaurant;

import jakarta.persistence.EntityManager;

@Repository //to declare a spring bean - containing Data access logic
//singleton n eager
public class RestaurantDaoImpl implements RestaurantDao {
	/*
	 * depcy - jakarta.persistence.EntityManager
	 * EntityManager - is super interface of Session
	 */
	@Autowired // byType or @PersistenceContext - JPA annotation
	private EntityManager manager;

	@Override
	public List<Restaurant> getAllRestaurants() {
		String jpql="select r from Restaurant r";		
		return manager //hibernate -current session cant be configured
				.createQuery(jpql, Restaurant.class)
				.getResultList();
	}

}
