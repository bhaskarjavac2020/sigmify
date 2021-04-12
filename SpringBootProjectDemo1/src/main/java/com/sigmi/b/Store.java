package com.sigmi.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("sobj")
public class Store {
	@Value("123")
	private int pid;
	@Value("Send")
	private String pcode;
	@Autowired
	private Book book;
	
	public void getStore() {
		System.out.println("Product ID "+pid+" Product code "+pcode);
		book.getBookDetails();
	}
	
}
