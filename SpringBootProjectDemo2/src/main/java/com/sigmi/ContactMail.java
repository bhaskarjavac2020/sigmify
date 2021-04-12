package com.sigmi;

import org.springframework.stereotype.Component;

@Component("mail")
public class ContactMail implements IContactData {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("ContactMail.show()");
	}
}
