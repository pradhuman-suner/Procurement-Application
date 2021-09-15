package com.inn.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.Dao.OrderDao;
import com.inn.model.Order;
import com.inn.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public Order saveOrder(Order order) {
		
		return orderDao.save(order);
		
	}
	
	
	
	@Override
	public List<Order> showOrder() {
		
		 return orderDao.findAll();
		 
		 
	}
	
	
	
	@Override
	public Optional<Order> getByID(int id) {
		return orderDao.findById(id);
	}
	
	
	

	@Override
	public String deleteOrder(int id)
	{
		orderDao.deleteById(id);;
		return "";
		
	}
	

	@Override
	public Order updateOrder(int id, Order order)
	{
		
		Order o = orderDao.findById(id).get(); 
		o.setPrice(order.getPrice());
		o.setProductIdList(order.getProductIdList());
		
		return orderDao.save(o);
		
	}
	

}
