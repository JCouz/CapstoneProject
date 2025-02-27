package com.fd.foodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.foodDelivery.entity.Order;
import com.fd.foodDelivery.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public List<Order> getAllOrders() {
		return repo.findAll();
	}

	public Order getOrderById(int id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException(id + " not found");
		}
		return repo.findById(id).get();
	}

	public Order createOrder(Order order) {
		return repo.save(order);
	}

	public Order updateOrder(int id, Order order) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException(id + " not found");
		}
		order.setId(id);
		return repo.save(order);
	}

	public void deleteOrder(int id) {
		if (repo.existsById(id))
			repo.deleteById(id);
	}
}
