package com.inn.service;

import java.util.List;
import java.util.Optional;

import com.inn.model.Order;

public interface OrderService {
	
	
	Order saveOrder(Order order);

	List<Order> showOrder();

	Optional<Order> getByID(int id);

	String deleteOrder(int id);

	Order updateOrder(int id, Order order);

}
