package com.fd.foodDelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fd.foodDelivery.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
