package com.epam.project.repository;

public interface ProductRepo {
	public int getProductid() ;
	public void setProductid(int productid);
	public String getName();
	public void setName(String name);
	public int getPrice();
	public void setPrice(int price);
	public int getQuantity();
	public void setQuantity(int quantity);
}
