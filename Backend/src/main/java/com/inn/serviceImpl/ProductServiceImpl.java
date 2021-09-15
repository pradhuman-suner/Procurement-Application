package com.inn.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.Dao.ProductDao;
import com.inn.model.Product;
import com.inn.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{
	
		
		@Autowired
		ProductDao productDao;
		
		public Product saveProduct(Product product) {
			
			productDao.save(product);
			return product;
		}
		
		
		
		@Override
		public List<Product> showProduct() {
			
			 return productDao.findAll();
			 
			 
		}
		
		
		@Override
		public Optional<Product> getByID(int id) {
			return productDao.findById(id);
		}
		

		@Override
		public Product getByProductName(String productName) {
			return productDao.findByProductName(productName);		
		}
		
		
		@Override
		public String deleteProduct(int id)
		{
			productDao.deleteById(id);;
			return "";
			
		}
		

		@Override
		public Product updateProduct(int id, Product product)
		{
			try
			{
			Product p = productDao.findById(id).get(); 
			p.setProductName(product.getProductName());
			p.setProductCategory(product.getProductCategory());
			p.setThresholdValue(product.getThresholdValue());
			p.setProductDescription(product.getProductDescription());
			p.setProductImage(product.getProductImage());
			p.setProductPrice(product.getProductPrice());
			return productDao.save(p);
			}
			catch (Exception e) {
				return null;
			}
		}
		
		public Product updateProductThresholdValue(int id, Product product)
		{
			Product p = productDao.findById(id).get(); 
			p.setThresholdValue(product.getThresholdValue());
			return productDao.save(p);
			
		}
		
	}
	

