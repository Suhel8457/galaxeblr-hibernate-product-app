package com.training.galaxe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	private int productId;
	@Column(name="ProductName")
	private String productName;
	@Column(name="ProductPrice")
	private int price;


	@Override
	public String toString() {
		return "\nProduct [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product(int productId, String productName, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public Product(int productId2) {
		// TODO Auto-generated constructor stub
		this.productId = productId;
	}

	public Product() {
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
