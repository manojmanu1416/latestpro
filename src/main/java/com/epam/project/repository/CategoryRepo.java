package com.epam.project.repository;

import java.util.Map;


import com.epam.project.entities.SubCategory;

public interface CategoryRepo{
	public int getCategoryid();
	public void setCategoryid(int subCategoryid);
	public String getName();
	public void setName(String name);
	public Map<Integer, SubCategory> getSubCategory();
	public void setSubCategory(Map<Integer, SubCategory> subCategory);
	public void displaySubcategories();
}
