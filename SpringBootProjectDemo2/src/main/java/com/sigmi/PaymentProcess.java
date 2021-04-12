package com.sigmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcess {
	@Autowired
	@Qualifier("mail")
	private IContactData sms;
	
	public void testPay() {
		System.out.println("From Payment");
		sms.show();
	}
}
