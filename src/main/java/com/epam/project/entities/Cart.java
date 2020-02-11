package com.epam.project.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.project.repository.CartRepo;
public class Cart implements  CartRepo{
	private static final Logger logger = LogManager.getLogger(Cart.class);
	List<Product> cartlist;
	double finalprice;
	public Cart() {
		super();
		this.cartlist = new ArrayList<Product>();
		this.finalprice = 0;
	}

public String addProductToCart(Product requiredproduct, int requiredquantity) {
		if(requiredproduct ==null)
			return "*************no product exist for that id*************";
		//condition for quantity not exist
		if(requiredquantity>requiredproduct.getQuantity())
			return "*************cannot add to cart(quantity not exist)*************";
		
		finalprice=finalprice+requiredproduct.getPrice()*requiredquantity;
		requiredproduct.setQuantity(requiredproduct.getQuantity()-requiredquantity);
		cartlist.add(new Product(requiredproduct,requiredquantity));
		
		return "*************product added to cart*************";
	}
	public void showCartProducts() {
		String print=String.format("%-10s %-20s %-20s%n","productid","productname","productqunatity");
		logger.info(print);
		for(Product product :cartlist) {
			print=String.format("%-10s %-20s %-20s%n",product.getProductid(),product.getName(),product.getQuantity());
			logger.info(print);
		}
		print=String.format("%-10s %-20s%n","finalprice",finalprice);
		logger.info(print);
	}

	public String addProductToCart(int requiredproductid, int requiredquantity) {
		String result="";
		try(Connection con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/ecommerces", "root", "root");
		         Statement stmt = con.createStatement();
		         ResultSet rs = stmt.executeQuery(
		            "SELECT productid,name,price,quantity FROM product WHERE subcategoryid = '"+requiredproductid+"' ")){
			if(rs.next()==false) {
				result= "*************no product exist for that id*************";
			}
			else if(rs.getInt("quantity")<requiredquantity){
				result= "*************cannot add to cart(quantity not exist)*************";
			}
			else {
				 int newquantity = rs.getInt("quantity") - requiredquantity;
				 Statement stmt1 = con.createStatement();
		         int rs1 = stmt.executeUpdate("update product set quantity='"+newquantity +"' where productid= '"+requiredproductid +"'");
		         result="*************product added to cart*************";
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}

}
