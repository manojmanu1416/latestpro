package com.epam.project.exception;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocalExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger(LocalExceptionHandler.class);
	public int getInt() {
		Scanner scan=new Scanner(System.in);
		try {
			return Integer.parseInt(scan.next());
		} catch (Exception e) {
			logger.info("enter valid number");
		}
	
		return getInt();
	}
//	public boolean nullExceptionHandler(Object a) {
//		Optional<Object> checkNull = Optional.ofNullable(a); 
//		return checkNull.isPresent() ? true :false;
//}
}