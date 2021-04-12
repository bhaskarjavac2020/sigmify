package com.sigmi.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmi.dto.AddressDTO;
import com.sigmi.dto.UserDTO;
import com.sigmi.entity.Address;
import com.sigmi.entity.User;
import com.sigmi.entity.UserType;
import com.sigmi.repository.UserRepository;
import com.sigmi.repository.UserTypeRepository;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
	private UserRepository repo;
//    @Autowired
//    private UserTypeRepository typerepo;
//	
	
	@Override
	public Integer registreUser(UserDTO dto) throws Exception {
//		UserType usertype=typerepo.findByUtype(dto.getUtype().getUtype());
//		if(usertype!=null) {
//			dto.getUtype().setUid(usertype.getUid());
//		}
		InputStream is=new FileInputStream(dto.getPhotoadd());
		byte[] photocontent=new byte[is.available()];
		is.read(photocontent);
		User user= new User();
		BeanUtils.copyProperties(dto, user);
		user.setPhoto(photocontent);
		List<Address> address=new ArrayList<Address>();
		//for changing addressDTO to Address
		for (AddressDTO dto1 : dto.getAddress()) {
			Address add=new Address();
			BeanUtils.copyProperties(dto1, add);
			address.add(add);
		}
		user.setAddress(address);
		System.out.println(dto);
		System.out.println(user);
		
		int id= repo.save(user).getId();
		
		return id;
	}


	@Override
	public List<User> fetchAllUser() throws Exception {
		return repo.findAll();
	}


	@Override
	public User fetchUserById(Integer id) {
		Optional<User> opt=repo.findById(id);
		User user=null;
		if (opt.isPresent()) {
			user=opt.get();
		}
		return user;
	}


	@Override
	public String deleteUser(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "User with given id "+id+" removed";
		}else {
			return "invalid userid";
		}
	}


	@Override
	public String updateUser(UserDTO dto) throws Exception {
		User user=fetchUserById(dto.getId());
		 BeanUtils.copyProperties(dto, user); 
		 List<Address> address=new ArrayList<Address>();
		 for(AddressDTO dto1:dto.getAddress()) {
		  Address add=new Address(); 
		  BeanUtils.copyProperties(dto1, add);
		  address.add(add); 
		  }
		 InputStream is=new FileInputStream(dto.getPhotoadd());
			byte[] photocontent=new byte[is.available()];
			is.read(photocontent);
			user.setPhoto(photocontent);
		 user.setAddress(address);
	
		//save user using updated value
	   User user1=repo.save(user);
		if(user1!=null) {
			return "User with id "+user1.getId()+" updated";
		}else {
		return "Problem in record updation";
		}
	}
	
	
}
