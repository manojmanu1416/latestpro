package com.epam.project.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.project.database.DataHolder;
import com.epam.project.entities.Cart;
import com.epam.project.exception.LocalExceptionHandler;

public class UI {
	private static final Logger logger = LogManager.getLogger(UI.class);
	private LocalExceptionHandler exceptionhandler;
	private Cart mycart;

	private DataHolder dataholder;
	
	public UI() {
		super();
		dataholder=new DataHolder();
		 exceptionhandler= new LocalExceptionHandler();
		mycart = new Cart();

	}
	public void shoppingMenu() {

		dataholder.displayCategory();

		showCategoryMenu();

	}

	private void showCategoryMenu() {
		logger.info("Enter the id to open category");

		int categoryoption = exceptionhandler.getInt();

		displaySubCategory(categoryoption);
	}

	private void displaySubCategory(int categoryoption) {
		try {
			dataholder.displaySubCategory(categoryoption);
		} catch (Exception e) {
			logger.info("enter valid id");
			showCategoryMenu();
		}
		

		showSubCategoryMenu(categoryoption);
	}

	private void showSubCategoryMenu(int categoryoption) {
		logger.info("Enter the id to open products in subcategory or 0 to go back");

		int subcategoryoption = exceptionhandler.getInt();
		if (subcategoryoption == 0)
			shoppingMenu();
		else {
			try {
				displayProducts(subcategoryoption);
				
			} catch (Exception e) {
				logger.info("enter valid id");
				showSubCategoryMenu(categoryoption);
			}
			
		}
	}

	private void displayProducts(int subcategoryoption) {
		dataholder.displayproducts(subcategoryoption);
		
		showProductsMenu(subcategoryoption);

	}

	private void showProductsMenu(int subcategoryoption) {
		logger.info("enter 1 to add product");
		logger.info("enter 2 to go to category");
		logger.info("enter 0 to got to cart");
		logger.info("enter any key to exit");

		int option = exceptionhandler.getInt();

		switch (option) {
		case 1:
			addToCartMenu(subcategoryoption);
			displayProducts(subcategoryoption);
			break;
		case 2:
			shoppingMenu();
			break;
		case 0:
			showCart();
			break;
		default:
			System.exit(0);
			break;

		}

	}

	private void showCart() {
		mycart.showCartProducts();

		showCartMenu();

	}

	private void showCartMenu() {
		logger.info("enter 1 to place order");
		logger.info("enter 2 to go to category");
		logger.info("enter any number to exit");
		int option = exceptionhandler.getInt();
		switch (option) {
		case 1:
			logger.info("order placed.......");
			break;
		case 2:
			shoppingMenu();
			break;
		default:
			System.exit(0);
			break;

		}
	}

	public void addToCartMenu(int subcategory) {
		logger.info("enter productid to add to cart");
		int productid = exceptionhandler.getInt();
		logger.info("enter quantity");
		int quantity = exceptionhandler.getInt();
		String s=mycart.addProductToCart(productid, quantity);
		logger.info(s);

	}

	

}
