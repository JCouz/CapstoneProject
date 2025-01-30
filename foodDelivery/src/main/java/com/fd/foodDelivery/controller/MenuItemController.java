package com.fd.foodDelivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fd.foodDelivery.entity.MenuItem;
import com.fd.foodDelivery.service.MenuItemService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	private MenuItemService service;

	@GetMapping
	public List<MenuItem> getAllMenuItems() {
		return service.getAllMenuItems();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getMenuitembyId(@PathVariable int id) {
		try {
			MenuItem menuItem = service.getMenuItemById(id);
			return ResponseEntity.ok(menuItem);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> createMenuItem(@RequestBody MenuItem menuItem){
		try {
			MenuItem createdMenuItem = service.createMenuItem(menuItem);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdMenuItem);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(errorMap);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateMenuItem(@PathVariable int id, @RequestBody MenuItem menuItem){
		try {
			MenuItem updateMenuItem = service.updateMenuitem(id, menuItem);
			return ResponseEntity.ok(updateMenuItem);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMenuItem(@PathVariable int id){
		try {
			service.deleteMenuItem(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}

}
