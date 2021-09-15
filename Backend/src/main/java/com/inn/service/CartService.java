package com.inn.service;

import java.util.List;
import java.util.Optional;

import com.inn.model.Cart;

public interface CartService {

	List<Cart> showCart();

	Optional<Cart> getByID(int id);

	
	String deleteCart(int id);

	Cart updateCart(int id, Cart cart);

}
