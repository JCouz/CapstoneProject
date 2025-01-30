package com.fd.foodDelivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fd.foodDelivery.entity.Restaurant;
import com.fd.foodDelivery.service.RestaurantService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@GetMapping
	public List<Restaurant> getAllRestaurants() {
		return service.getAllRestaurants();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getRestaurantById(@PathVariable int id) {
		try {
			Restaurant restaurant = service.getRestaurantById(id);
			return ResponseEntity.ok(restaurant);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> createRestaurant(@RequestBody Restaurant restaurant){
		try {
			Restaurant createRestaurant = service.createRestaurant(restaurant);
			return ResponseEntity.status(HttpStatus.CREATED).body(createRestaurant);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(errorMap);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant){
		try {
			Restaurant updatedRestaurant = service.updateRestaurant(id, restaurant);
			return ResponseEntity.ok(updatedRestaurant);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRestaurant(@PathVariable int id){
		try {
			service.deleteRestaurant(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}
	
}
