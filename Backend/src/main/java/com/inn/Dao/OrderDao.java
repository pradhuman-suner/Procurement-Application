package com.inn.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inn.model.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
