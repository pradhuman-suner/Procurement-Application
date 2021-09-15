package com.inn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;  
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "product_id", columnDefinition = "INT")
//	private Product product;
	
	private int productId;
	private String productName;       
	private String productCategory;   
	private String productDescription;   
	private long productPrice;       
	private long thresholdValue;
	private int userId;
	private long quantity;
	private long total;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public Cart(int id, int productId, String productName, String productCategory, String productDescription,
			long productPrice, long thresholdValue, int userId, long quantity, long total) {
		super();
		Id = id;
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.thresholdValue = thresholdValue;
		this.userId = userId;
		this.quantity = quantity;
		this.total = total;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [Id=" + Id + ", productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDescription=" + productDescription + ", productPrice=" + productPrice
				+ ", thresholdValue=" + thresholdValue + ", userId=" + userId + ", quantity=" + quantity + ", total="
				+ total + "]";
	}
	
	
	
	
}
