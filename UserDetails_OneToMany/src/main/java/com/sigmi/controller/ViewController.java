package com.sigmi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sigmi.dto.ViewDTO;
import com.sigmi.entity.User;
import com.sigmi.repository.AddressRepository;
import com.sigmi.repository.UserRepository;

@RestController
public class ViewController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AddressRepository addrsRepo;
	
	@PostMapping("/saveUser")
	public User userAddrs(@RequestBody User user) {
		return userRepo.save(user);
		
	}
	@GetMapping("/findAllUsers")
	public List<User> findAllUsers(){
		return userRepo.findAll();
	}
}
