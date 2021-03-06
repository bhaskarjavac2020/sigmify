package com.sigmi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigmi.dto.AddressDTO;
import com.sigmi.dto.UserDTO;
import com.sigmi.entity.User;
import com.sigmi.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
      private IUserService service;
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserDTO dto) throws Exception{
		System.out.println(dto);
          Integer id=service.registreUser(dto);
	   return new ResponseEntity<String>("User data saved with "+id,HttpStatus.OK);
   }
//--------------------------get all users----------------------------------------------------
	
	@GetMapping("/getall")
	public ResponseEntity<List<UserDTO>> getAllUser(@RequestBody User user) throws Exception
	{
		List<UserDTO> userList=service.fetchAllUser();
		return new ResponseEntity<List<UserDTO>>(userList,HttpStatus.OK);
		
	}
	
//--------------------------get all user by id----------------------------------------------------	
@GetMapping("/get/{id}")
	public ResponseEntity<UserDTO>getOneUser(@PathVariable Integer id){
		UserDTO userdto=service.fetchUserById(id);
		return new ResponseEntity<UserDTO>(userdto,HttpStatus.OK);
	}

//--------------------------delete user by id----------------------------------------------------
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		String response=service.deleteUser(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
//--------------------------delete address by id----------------------------------------------------
     @DeleteMapping("/delete/address/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable Integer id){
	   String response=service.deleteAddress(id);
	   return new ResponseEntity<String>(response,HttpStatus.OK);
}
//--------------------------update by id----------------------------------------------------	
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id,
			                                  @RequestBody UserDTO dto) throws Exception{
		for(AddressDTO dto1:dto.getAddress()) {
		   System.out.println(dto1.getAddress_id());
		}
		String response=service.updateUser(dto);
		
	return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
}
