package com.epam.project.repository;

import java.util.Map;

import com.epam.project.entities.Product;

public interface SubCategoryRepo {
	public int getSubCategoryid();
	public void setSubCategoryid(int subCategoryid);
	public String getName();
	public void setName(String name);
	public Map<Integer, Product> getProducts();
	public void setProducts(Map<Integer, Product> products);
	public void displayProducts();
}
