package com.inn.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderDetail")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int orderDate;
	private int price;
	private String productIdList;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	

	public int getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(int orderDate) {
		this.orderDate = orderDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductIdList() {
		return productIdList;
	}

	public void setProductIdList(String productIdList) {
		this.productIdList = productIdList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", price=" + price + ", productIdList="
				+ productIdList + "]";
	}

	public Order(int orderId, int orderDate, int price, String productIdList) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.price = price;
		this.productIdList = productIdList;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	
}
