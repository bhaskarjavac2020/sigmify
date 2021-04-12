package com.sigmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootProjectDemo2Application {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(SpringBootProjectDemo2Application.class, args);
	PaymentProcess pp=ac.getBean("paymentProcess",PaymentProcess.class);
	pp.testPay();
	}
}
