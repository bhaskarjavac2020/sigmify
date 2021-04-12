/*
 * package com.sigmi.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component;
 * 
 * import com.sigmi.entity.Address; import com.sigmi.entity.User; import
 * com.sigmi.service.IUserService;
 * 
 * @Component public class UserRunner implements CommandLineRunner {
 * 
 * @Autowired private IUserService service;
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * User user=new User(); user.setFname("bhasker"); user.setLname("senapati");
 * user.setPassword("123"); user.setRepeatPassword("123");
 * user.setEmail("abc@gmail.com"); user.setPhone(24134141L); Address ad=new
 * Address(); ad.setAddress("anasandrapalya"); ad.setCityLocality("ramatemple");
 * ad.setDistrict("vimanpura"); ad.setState("banglore"); ad.setPin(560014);
 * user.setAddress(List.of(ad));
 * 
 * int id=service.registreUser(user); System.out.println(id);
 * service.getAllUser();
 * 
 * //System.out.println("UserRunner.run()");
 * 
 * }
 * 
 * }
 */