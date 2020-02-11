package com.epam.project.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        logger.info("1.Shopping ");
        logger.info("2.exit");
		int option = scan.nextInt();

		if (option == 1) {
			new UI().shoppingMenu();
		} else {
			System.exit(0);

		}
	}
}
