package com.inn.restImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inn.model.Product;
import com.inn.rest.ProductRest;
import com.inn.serviceImpl.ProductServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
@SwaggerDefinition(tags = {
	    @Tag(name = "ProductRestImpl", description = "Rest APIs related to product") })
public class ProductRestImpl implements ProductRest{
	
	private byte[] bytes;
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	public void uploadImage(MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	@Override 
	@ApiOperation(value="Register Product",notes="This Api Registers products")
	public String registerProduct(Product Product)
	{
		
		productServiceImpl.saveProduct(Product);
		return "Product added ";
		
	}
		
	@Override
	@ApiOperation(value="gets Products",notes="This Api gets all products")
	public List<Product> getProducts()
	{
		
		return productServiceImpl.showProduct();
		
	}
	
	@Override
	@ApiOperation(value="gets Product by id",notes="This Api gets Products by id's")
	public Optional<Product> getProductById(int id) {
		return productServiceImpl.getByID(id);
	}
	
	@Override 
	@ApiOperation(value="get Product by name",notes="This Api gets products by name")
	public Product getByProductName(String ProductName) {
		return productServiceImpl.getByProductName(ProductName);		
	}
	
	
	@Override 
	@ApiOperation(value="Delete Product",notes="This Api deletes products")
	public String deleteProduct(int id)
	{
		productServiceImpl.deleteProduct(id);;
		return "";
		
	}
	
	@Override
	public Product updateProductThresholdValue(int id, Product Product)
	{
		return productServiceImpl.updateProductThresholdValue(id, Product);
		
	}
	

	@Override
	@ApiOperation(value="Update Product",notes="This Api update product")
	public Product updateProduct(int id, Product Product)
	{
		return productServiceImpl.updateProduct(id, Product);
		
	}
	
}
