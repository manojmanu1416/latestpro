package com.epam.project.entities;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.project.repository.CategoryRepo;

public class Category implements CategoryRepo{
	private static final Logger logger = LogManager.getLogger(Category.class);
	private static int categoryuniqueid=0;
	private int categoryid;
	
	private String name;
	private Map<Integer,SubCategory> subCategory;
	public Category( String name) {
		super();
		 categoryuniqueid++;
		this.categoryid = categoryuniqueid;
		this.name = name;
		this.subCategory = new HashMap<Integer,SubCategory>();
	}
	
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Map<Integer, SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + ", subCategory=" + subCategory + "]";
	}
	public void displaySubcategories() {
		String print=String.format("%-15s %-20s%n","subCategoryid","subCategoryName");
		logger.info(print);
		for(Map.Entry<Integer,SubCategory> subcategoryentry:subCategory.entrySet()) {
			print=String.format("%-15s %-20s%n",subcategoryentry.getKey(),subcategoryentry.getValue().getName());
			logger.info(print);
		}
		
	}
	
}
