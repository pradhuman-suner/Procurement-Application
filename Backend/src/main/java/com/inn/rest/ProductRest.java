package com.inn.rest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.inn.model.Product;

public interface ProductRest {
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException;
	
	
	@PostMapping("/registerProduct")
	public String registerProduct(@RequestBody Product Product);
	
	@GetMapping("/getProducts")
	public List<Product> getProducts();
	 
	@GetMapping("/getProductById/{id}")
	public Optional<Product> getProductById(@PathVariable int id);
	 
	@GetMapping("/getProductByName/{ProductName}")
	public Product getByProductName(@PathVariable String ProductName);
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id);

	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable int id,@RequestBody Product Product);
	
	@PutMapping("/updateProductThresholdValue/{id}")
	public Product updateProductThresholdValue(@PathVariable int id,@RequestBody Product Product);

}
