package com.sigmi;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sigmi.entity.Address;
import com.sigmi.entity.User;
import com.sigmi.service.IUserService;

@SpringBootApplication
public class SpringDataJpaOneToManyRelationApplication {

	public static void main(String[] args) {
		/* ApplicationContext ctx= */ SpringApplication.run(SpringDataJpaOneToManyRelationApplication.class, args);
	/*
	 * IUserService service=ctx.getBean(IUserService.class); User user=new User();
	 * user.setFname("bhasker"); user.setLname("senapati"); user.setPassword("123");
	 * user.setReteatPassword("123"); user.setEmail("abc@gmail.com");
	 * user.setPhone(24134141L); Address ad=new Address();
	 * ad.setAddress("anasandrapalya"); ad.setCityLocality("ramatemple");
	 * ad.setDistrict("vimanpura"); ad.setState("banglore"); ad.setPin(560014);
	 * user.setAddress(List.of(ad)); int id=service.registreUser(user);
	 * System.out.println("in controller"+id);
	 */
	}

}
