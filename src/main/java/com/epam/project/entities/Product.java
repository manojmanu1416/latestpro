package com.epam.project.entities;

import com.epam.project.repository.ProductRepo;

public class Product implements ProductRepo{

	private static int uniqueid=0;
	private int productid;
	private String name;
	private int price;
	private int quantity;
	public Product(String name, int price,int quantity) {
		super();
		uniqueid++;
		this.productid = uniqueid;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Product(Product product,int quantity) {
		super();
		
		this.productid = product.productid;
		this.name = product.name;
		this.price = product.price;
		this.quantity = quantity;
	}
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + productid + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
	
}
