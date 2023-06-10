package com.java.farmfresh.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.farmfresh.entity.Food;
import com.java.farmfresh.service.FoodService;

@RestController
@RequestMapping(path = "/api/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<Food> getById(@PathVariable("id") Integer id) {
		try {
			Food food = foodService.get(id);
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/getAllFoods")
	public ResponseEntity<List<Food>> getAllFoods() {
		List<Food> foods = foodService.listAll();
		return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getByName/{name}")
	public ResponseEntity<List<Food>> getByName(@PathVariable("name") String name) {
		List<Food> foods = foodService.findByName(name);
		return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
	}
}
