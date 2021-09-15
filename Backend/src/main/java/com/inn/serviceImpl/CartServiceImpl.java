package com.inn.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.Dao.CartDao;
import com.inn.model.Cart;
import com.inn.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;
	
	public Cart saveCart(Cart cart) {
		
		cartDao.save(cart);
		return cart;
	}
	
	public List<Cart> showCartByUserID(int userId) {
		return cartDao.findAllByUserId(userId);
	}
	
	public long getCartListTotalByUserId(int userId) {
		return cartDao.getCartListTotalByUserId(userId);
	}
	
	@Override
	public List<Cart> showCart() {
		return cartDao.findAll();
		
		
	}

	@Override
	public Optional<Cart> getByID(int id) {
		return cartDao.findById(id);
	}

	@Override
	public String deleteCart(int id) {
		cartDao.deleteById(id);
		return "";
	}
	
	public String deleteCartByUserId(int userId) {
		cartDao.deleteAllByUserId(userId);
		return "";
	}

	@Override
	public Cart updateCart(int id, Cart cart) {

		Cart c = cartDao.findById(id).get();
		c.setProductId(cart.getProductId());
		c.setQuantity(cart.getQuantity());
		c.setProductCategory(cart.getProductCategory());
		c.setProductDescription(cart.getProductDescription());
		c.setTotal(cart.getTotal());
		c.setProductPrice(cart.getProductPrice());
		c.setProductName(cart.getProductName());
		c.setThresholdValue(cart.getThresholdValue());
		return cartDao.save(c);
	}

}
