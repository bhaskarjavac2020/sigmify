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

import com.sigmi.dto.StateDTO;
import com.sigmi.dto.UserDTO;
import com.sigmi.entity.State;
import com.sigmi.entity.User;
import com.sigmi.service.IDistrictService;
import com.sigmi.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
     private IUserService service;
	@Autowired
	private IDistrictService idistService;
	//------save districts-----------
	@PostMapping("/saveDist")
	public ResponseEntity<String> saveDist(@RequestBody StateDTO statedto) throws Exception{
		System.out.println(statedto);
          Integer id=idistService.saveStateData(statedto);
	   return new ResponseEntity<String>("User data saved with "+id,HttpStatus.OK);
   }
	//-------------save user-------------
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserDTO userdto) throws Exception{
		System.out.println(userdto);
          Integer id=service.registreUser(userdto);
	   return new ResponseEntity<String>("User data saved with "+id,HttpStatus.OK);
   }
//--------------------------get all users----------------------------------------------------
	
	@GetMapping("/getall")
	public ResponseEntity<List<UserDTO>> getAllUser() throws Exception
	{
		List<UserDTO> userList=service.fetchAllUser();
		return new ResponseEntity<List<UserDTO>>(userList,HttpStatus.OK);
		
	}
//--------------------------get all state----------------------------------------------------
	@GetMapping("/getAllState")
	public ResponseEntity<List<StateDTO>> getAllState() throws Exception
	{
		List<StateDTO> stateList=idistService.fetchAllState();
		return new ResponseEntity<List<StateDTO>>(stateList,HttpStatus.OK);	
	}
			
//--------------------------get all user by id----------------------------------------------------	
@GetMapping("/get/{id}")
	public ResponseEntity<User>getOneUser(@PathVariable Integer id){
		User user=service.fetchOneUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
//--------------------------get all district by stateid----------------------------------------------------	
@GetMapping("/getState/{id}")
	public ResponseEntity<StateDTO>getOneState(@PathVariable Integer id){
		StateDTO stateDto=idistService.fetchOneState(id);
		return new ResponseEntity<StateDTO>(stateDto,HttpStatus.OK);
	}
//--------------------------delete user by id----------------------------------------------------
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		String response=service.deleteUser(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
//--------------------------delete state by id----------------------------------------------------
   @DeleteMapping("delete/state/{id}")
	public ResponseEntity<String> deleteState(@PathVariable Integer id){
	  String response=idistService.deleteState(id);
	  return new ResponseEntity<String>(response,HttpStatus.OK);
  }
	//--------------------------delete address by id----------------------------------------------------
     @DeleteMapping("/delete/address/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable Integer id){
	   String response=service.deleteAddress(id);
	   return new ResponseEntity<String>(response,HttpStatus.OK);
}
//--------------------------update by id----------------------------------------------------	
	@PutMapping("/modify")
	public ResponseEntity<String> updateUser(@RequestBody UserDTO userdto) throws Exception{
		Integer id1=service.updateUser(userdto);
		
	return new ResponseEntity<String>("User updated with "+id1,HttpStatus.OK);
		
	}
//--------------------------update by address----------------------------------------------------
@PutMapping("/modify/addrs")
	public ResponseEntity<String> updateNewAddress(
			@RequestBody UserDTO userdto
			) throws Exception{

		Integer id=service.updateAddress(userdto);
		return new ResponseEntity<String>("User add updated with id "+id,HttpStatus.OK);
		
	}	
}
