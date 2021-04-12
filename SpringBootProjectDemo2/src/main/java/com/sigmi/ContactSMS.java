package com.sigmi;

import org.springframework.stereotype.Component;

@Component("sms")
public class ContactSMS implements IContactData {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("ContactSMS.show()");
	}
}
