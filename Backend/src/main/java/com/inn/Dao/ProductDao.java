package com.inn.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{


	Product findByProductName(String productName);

}
