package com.sigmi.b;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bobj")
public class Book {
	@Value("1")
	private int slNo;
	@Value("Indomitable Spirit")
	private String bookName;
	@Value("245")
	private Double price;
	public void getBookDetails() {
		System.out.println("The sl no "+slNo+" of "+bookName+" is "+price+" rupees");
	}
}
