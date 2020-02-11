package com.epam.project.repository;

import com.epam.project.entities.Product;

public interface CartRepo {
	public String addProductToCart(Product requiredproduct, int requiredquantity);
	public void showCartProducts();
}
