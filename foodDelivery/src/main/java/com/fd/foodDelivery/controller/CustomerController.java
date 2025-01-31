package com.fd.foodDelivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fd.foodDelivery.entity.Customer;
import com.fd.foodDelivery.entity.Restaurant;
import com.fd.foodDelivery.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable int id) {
		try {
			Customer customer = service.getCustomerbyId(id);
			return ResponseEntity.ok(customer);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}

	@PostMapping
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		try {
			Customer createdCustomer = service.createCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(errorMap);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		try {
			Customer updatedCustomer = service.updateCustomer(id, customer);
			return ResponseEntity.ok(updatedCustomer);
		} catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
		try {
			service.deleteCustomer(id);
			return ResponseEntity.noContent().build();
		}catch (EntityNotFoundException e) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
	}

}
