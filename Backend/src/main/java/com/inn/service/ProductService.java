package com.inn.service;

import java.util.List;
import java.util.Optional;

import com.inn.model.Product;


public interface ProductService {

	List<Product> showProduct();

	Optional<Product> getByID(int id);

	
	String deleteProduct(int id);

	Product updateProduct(int id, Product product);

	Product getByProductName(String productName);

	

}
