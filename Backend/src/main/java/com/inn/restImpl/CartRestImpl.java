package com.inn.restImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.inn.model.Cart;
import com.inn.rest.CartRest;
import com.inn.serviceImpl.CartServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;


@Transactional 
@CrossOrigin("*")
@RestController
@SwaggerDefinition(tags = {
	    @Tag(name = "CartRestImpl", description = "Rest APIs related to cart") })
public class CartRestImpl implements CartRest{

	@Autowired
	CartServiceImpl cartServiceImpl;
	
	
	@Override
	@ApiOperation(value="Register cart",notes="This Api saves orders to cart")
	public String registerCart(Cart cart) {
		cartServiceImpl.saveCart(cart);
		return "Added To Cart";
	}
	
	@Override
	@ApiOperation(value="gets cart by user id",notes="This Api gets orders by orderid")
    public List<Cart> getCartByUserID(int userId) {
		
		return cartServiceImpl.showCartByUserID(userId);
	}
	
	@Override
	@ApiOperation(value="get total price of cart items by user",notes="This Api Get Total Price Of Cart Items")
    public long getCartListTotalByUserId(int userId) {
		
		return cartServiceImpl.getCartListTotalByUserId(userId);
	}

	@Override
	@ApiOperation(value="get cart",notes="This Api get cart")
	public List<Cart> getCart() {
		
		return cartServiceImpl.showCart();
	}

	@Override
	@ApiOperation(value="Register cart",notes="This Api get cart data related to user")
	public Optional<Cart> getCartById(int id) {
		return cartServiceImpl.getByID(id);
	}

	@Override
	@ApiOperation(value="deletes cart",notes="This Api deletes orders from cart")
	public String deleteCart(int id) {
		cartServiceImpl.deleteCart(id);
		return "";
	}
	
	@Override
	public String deleteCartByUserId(int userId) {
		cartServiceImpl.deleteCartByUserId(userId);
		return "";
	}

	@Override
	@ApiOperation(value="update cart",notes="This Api updates orders in cart")
	public Cart updateCart(int id, Cart cart) {
		return cartServiceImpl.updateCart(id, cart);
	}

}
