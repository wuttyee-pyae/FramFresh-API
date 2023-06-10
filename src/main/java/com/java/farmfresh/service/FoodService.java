package com.java.farmfresh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.farmfresh.entity.Food;
import com.java.farmfresh.repository.FoodRepository;

@Service
@Transactional
public class FoodService {

	@Autowired
    private FoodRepository foodRepository;
     
    public List<Food> listAll() {
        return foodRepository.findAll();
    }
     
    public void save(Food food) {
    	foodRepository.save(food);
    }
     
    public Food get(Integer id) {
        return foodRepository.findById(id).get();
    }
     
    public void delete(Integer id) {
    	foodRepository.deleteById(id);
    }
    
    public List<Food> findByName(String name) {
        return foodRepository.findByNameContaining(name);
    }
}
