package com.inn.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inn.model.Order;

public interface OrderRest {
	
	@PostMapping("/saveOrder")
	Order saveOrder(@RequestBody Order order);

	@GetMapping("/showOrder")
	List<Order> showOrder();

	@GetMapping("/getOrderById/{id}")
	Optional<Order> getOrderByID(@PathVariable int id);

	@DeleteMapping("/deleteOrder/{id}")
	String deleteOrder(@PathVariable int id);

	@PutMapping("/updateOrder/{id}")
	Order updateOrder(@PathVariable int id,@RequestBody Order order);

}
