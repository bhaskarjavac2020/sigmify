package com.sigmi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("social")
@Primary
public class ContactSocial implements IContactData {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("ContactSocial.show()");
	}

}
