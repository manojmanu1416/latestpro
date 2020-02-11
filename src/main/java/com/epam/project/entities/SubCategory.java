package com.epam.project.entities;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.project.repository.SubCategoryRepo;

public class SubCategory implements SubCategoryRepo{
	private static final Logger logger = LogManager.getLogger(SubCategory.class);
	private static int subCategoryuniqueid = 0;
	private int subCategoryid;
	private String name;
	private Map<Integer,Product> products;
	public SubCategory( String name) {
		super();
		 subCategoryuniqueid ++;
		this.subCategoryid = subCategoryuniqueid ;
		this.name = name;
		this.products = new HashMap<Integer,Product>();
	}
	
	public int getSubCategoryid() {
		return subCategoryid;
	}

	public void setSubCategoryid(int subCategoryid) {
		this.subCategoryid = subCategoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<Integer, Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryid=" + subCategoryid + ", name=" + name + ", products=" + products + "]";
	}
	public void displayProducts() {
		String print=String.format("%-15s %-25s %-20s %-20s%n","productid","productName","productprice","productquantity");
		logger.info(print);
		for(Map.Entry<Integer, Product> productentry : products.entrySet()) {
			print=String.format("%-15s %-25s %-20s %-20s%n",productentry.getKey(),productentry.getValue().getName(),productentry.getValue().getPrice(),productentry.getValue().getQuantity());
			logger.info(print);
		}
		
	}
	
}
