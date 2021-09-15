package com.inn.restImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.inn.model.Order;
import com.inn.rest.OrderRest;
import com.inn.serviceImpl.OrderServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(tags = {
	    @Tag(name = "OrderRestImpl", description = "Rest APIs related to Order") })
public class OrderRestImpl implements OrderRest{
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@Override
	@ApiOperation(value="Save Orders",notes="This Api saves Orders")
	public Order saveOrder(Order order) {
		
		orderServiceImpl.saveOrder(order);
		return order;
	}
	
	
	@Override
	@ApiOperation(value="show Orders",notes="This Api show Orders")
	public List<Order> showOrder() {
		
		 return orderServiceImpl.showOrder();
		 
		 
	}
	
	
	@Override
	@ApiOperation(value="get Orders by Id",notes="This Api gets Orders by Id's")
	public Optional<Order> getOrderByID(int id) {
		return orderServiceImpl.getByID(id);
	}
	
	

	@Override
	@ApiOperation(value="delete Orders",notes="This Api deletes Orders by Id")
	public String deleteOrder(int id)
	{
		orderServiceImpl.deleteOrder(id);;
		return "";
		
	}
	
	@Override
	@ApiOperation(value="Update Orders",notes="This Api updates Orders")
	public Order updateOrder(int id, Order order)
	{
		
		return orderServiceImpl.updateOrder(id, order);
		
		
	}
	

}
