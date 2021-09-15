package com.inn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="productCatalog")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;          
	private String productName;       
	private String productCategory;   
	private String productDescription; 
	private byte[] productImage;    
	private long productPrice;       
	private long thresholdValue;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public long getThresholdValue() {
		return thresholdValue;
	}
	public void setThresholdValue(long thresholdValue) {
		this.thresholdValue = thresholdValue;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDescription=" + productDescription + ", productImage=" + productImage
				+ ", productPrice=" + productPrice + ", thresholdValue=" + thresholdValue + "]";
	}
	public Product(int productId, String productName, String productCategory, String productDescription,
			byte[] productImage, long productPrice, long thresholdValue) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.thresholdValue = thresholdValue;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
