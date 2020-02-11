package com.epam.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class DataHolder {
	private static final Logger logger = LogManager.getLogger(DataHolder.class);
	String format="%-15s %-20s%n";
	public DataHolder() {
		super();
	}
public void displayCategory() {
	try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerces", "root", "root");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT categoryid ,name FROM category")) {
		
		
		String print=String.format(format, "Categoryid", "CategoryName");
		logger.info(print);
		
        while (rs.next()) {
        	print=String.format(format, rs.getInt("categoryid"), rs.getString("name"));
            logger.info(print);
           
        }
    } catch (SQLException e) {

		logger.error(e);
	}


	}
public void displaySubCategory(int categoryoption) {
	try (Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ecommerces", "root", "root");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(
            "SELECT subcategoryid,name FROM subcategory WHERE categoryid = '"+categoryoption+"' ")) {
		String print=String.format(format, "subcategoryid", "subCategoryName");
		logger.info(print);
        while (rs.next()) {
        	print=String.format(format, rs.getInt("subcategoryid"), rs.getString("name"));
            logger.info(print);
           
        }
    } catch (SQLException e) {

		logger.error(e);
	}
	
}
public void displayproducts(int subcategoryoption) {
	try (Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ecommerces", "root", "root");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(
            "SELECT productid,name,price,quantity FROM product WHERE subcategoryid = '"+subcategoryoption+"' ")) {
		String print=String.format("%-15s %-25s %-20s %-20s%n","productid","productName","productprice","productquantity");
		logger.info(print);
        while (rs.next()) {
        	print=String.format("%-15s %-25s %-20s %-20s%n",rs.getInt("productid"),rs.getString("name"),rs.getInt("price"),rs.getInt("quantity"));
			logger.info(print);         
        }
    } catch (SQLException e) {

		logger.error(e);
	}
	
}
}
