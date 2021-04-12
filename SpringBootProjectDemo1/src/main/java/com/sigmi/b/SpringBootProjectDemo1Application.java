package com.sigmi.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sigmi.ContactMail;

@SpringBootApplication
public class SpringBootProjectDemo1Application {
	
	@Autowired(required = true)
	private ContactMail mails;

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(SpringBootProjectDemo1Application.class, args);
        Store st=ac.getBean("sobj",Store.class);
       st.getStore();
	}

}
