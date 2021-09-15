package com.inn.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inn.model.Cart;


public interface CartRest {

	@PostMapping("/registerCart")
	public String registerCart(@RequestBody Cart cart);
	
	@GetMapping("/getCart")
	public List<Cart> getCart();
	
	@GetMapping("/getCartListByUserId/{userId}")
	public List<Cart> getCartByUserID(@PathVariable int userId);
	
	@GetMapping("/getCartListTotalByUserId/{userId}")
	public long getCartListTotalByUserId(@PathVariable int userId);
	 
	@GetMapping("/getCartById/{id}")
	public Optional<Cart> getCartById(@PathVariable int id);
	 
	@DeleteMapping("/deleteCart/{id}")
	public String deleteCart(@PathVariable int id);
	
	@DeleteMapping("/deleteCartByUserId/{userId}")
	public String deleteCartByUserId(@PathVariable int userId);

	@PutMapping("/updateCart/{id}")
	public Cart updateCart(@PathVariable int id,@RequestBody Cart cart);
	
}
