package com.fd.foodDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fd.foodDelivery.entity.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{
	List<MenuItem> findByRestaurantId(int restaurantId);
}
