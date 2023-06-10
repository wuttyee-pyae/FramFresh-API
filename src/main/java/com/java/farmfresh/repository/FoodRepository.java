package com.java.farmfresh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.farmfresh.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{

	List<Food> findByNameContaining(String name);
	// select * from tb_food where name like '%name%';
}
