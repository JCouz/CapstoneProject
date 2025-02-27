package com.fd.foodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.foodDelivery.entity.MenuItem;
import com.fd.foodDelivery.repository.MenuItemRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemRepository repo;
	
	public List<MenuItem> getAllMenuItems(){
		return repo.findAll();
	}
	
	public MenuItem getMenuItemById(int id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Menu Item not found with id: " + id);
		}
		return repo.findById(id).get();
	}
	
	public MenuItem createMenuItem(MenuItem menuItem) {
		return repo.save(menuItem);
	}
	
	public MenuItem updateMenuitem(int id, MenuItem menuItem) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Menu Item not found with id: " + id);
		}
		menuItem.setId(id);
		return repo.save(menuItem);
	}

	public void deleteMenuItem(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
	
	public List<MenuItem> getMenuItemsByRestaurant(int restaurantId) {
	    return repo.findByRestaurantId(restaurantId);
	}
	
}
