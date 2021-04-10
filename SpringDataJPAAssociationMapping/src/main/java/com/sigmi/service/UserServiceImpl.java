package com.sigmi.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmi.dto.AddressDTO;
import com.sigmi.dto.AddressTypeDTO;
import com.sigmi.dto.UserDTO;
import com.sigmi.dto.UserTypeDTO;
import com.sigmi.entity.Address;
import com.sigmi.entity.AddressType;
import com.sigmi.entity.User;
import com.sigmi.entity.UserType;
import com.sigmi.repository.AddressTypeRepository;
import com.sigmi.repository.UserRepository;
import com.sigmi.repository.UserTypeRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository urepo;
	@Autowired
	private UserTypeRepository utrepo;
	@Autowired
    private AddressTypeRepository adrepo;
	@Override
	public Integer registreUser(UserDTO dto) throws Exception {
		UserType usertype=null;
		AddressType addtype=null;
		List<Address> address=new ArrayList<Address>();
		InputStream is=new FileInputStream(dto.getPhotoadd());
		byte[] photocontent=new byte[is.available()];
		is.read(photocontent);
		User user= new User();
		user.setFname(dto.getFname());
		user.setLname(dto.getLname());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		user.setPhoto(photocontent);
		user.setPassword(dto.getPassword());
		if (dto.getUtype()!=null) {
			usertype=utrepo.findByName(dto.getUtype().getName());
			
				user.setUtype(usertype);
			}
		user.setUtype(usertype);
		//set address for user
		for (AddressDTO dto1 : dto.getAddress()) {
			Address add=new Address();
			add.setAddress(dto1.getAddress());
			add.setCityLocality(dto1.getCityLocality());
			add.setDistrict(dto1.getDistrict());
			add.setState(dto1.getState());
			add.setPin(dto1.getPin());
			if(dto1.getAtype()!=null) {
				addtype=adrepo.findByName(dto1.getAtype().getName());
				add.setAtype(addtype);
			}
			add.setAtype(addtype);
			address.add(add);
		}
		user.setAddress(address);
		System.out.println(dto);
		System.out.println(user);
		
		return urepo.save(user).getUid();
	}

	@Override
	public List<UserDTO> fetchAllUser() throws Exception {
		List<UserDTO> listudto=new ArrayList<UserDTO>();
		List<User> listuser =urepo.findAll();
		for (User user:listuser) {
			UserDTO udto=new UserDTO();
			udto.setFname(user.getFname());
			udto.setLname(user.getLname());
			udto.setPhone(user.getPhone());
			udto.setPassword(user.getPassword());
			udto.setEmail(user.getEmail());
			// convert and get photo address from byte array of photo content
			udto.setPhotoadd(Base64.getEncoder().encodeToString(user.getPhoto()));
		    // set the user type
			UserTypeDTO uTdto= new UserTypeDTO();
			uTdto.setName(user.getUtype().getName());
			uTdto.setDescription(user.getUtype().getDescription());
			udto.setUtype(uTdto);
			//set the address
			List<AddressDTO> listadto=new ArrayList<AddressDTO>();
	          for (Address address : user.getAddress()) {
				System.out.println(address);
			}
			for(Address add:user.getAddress()) {
		    	 AddressDTO adto= new AddressDTO();
		    	 adto.setAddress(add.getAddress());
		    	 adto.setCityLocality(add.getCityLocality());
		    	 adto.setDistrict(add.getDistrict());
		    	 adto.setState(add.getState());
		    	 adto.setPin(add.getPin());
		    	 AddressTypeDTO aTdto = new AddressTypeDTO();
		         System.out.println(add.getAtype().getName());
		         System.out.println(add.getAtype());
		    	 aTdto.setName(add.getAtype().getName());
		    	 aTdto.setDescription(add.getAtype().getDescription());
		    	 adto.setAtype(aTdto);
		    	 listadto.add(adto);
		     }
			udto.setAddress(listadto);
		listudto.add(udto);
		}
		return listudto;
	}

	@Override
	public User fetchUserById(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Integer uid) {
		if(urepo.existsById(uid)) {	
			   urepo.deleteById(uid);
			return "User with given id "+uid+" removed";
		}else {
			return "invalid userid";
		}
		
	}

	@Override
	public String updateUser(UserDTO dto) throws Exception {
		User user=null;
		Optional<User> opt=urepo.findById(dto.getUid());
		if(opt.isPresent()) {
			user=opt.get();
		}
		//------------------------copy dto to user------------------------------------------
		UserType usertype=null;
		AddressType addtype=null;
		List<Address> addresslist=new ArrayList<Address>();
		InputStream is=new FileInputStream(dto.getPhotoadd());
		byte[] photocontent=new byte[is.available()];
		is.read(photocontent);
		//User user= new User();
		user.setFname(dto.getFname());
		user.setLname(dto.getLname());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		user.setPhoto(photocontent);
		user.setPassword(dto.getPassword());
		if (dto.getUtype()!=null) {
			usertype=utrepo.findByName(dto.getUtype().getName());
			user.setUtype(usertype);
			}
		user.setUtype(usertype);
		//set address for user
		for (AddressDTO dto1 : dto.getAddress()) {
			
			Address add=new Address();
			add.setAddress_id(dto1.getAddress_id());
			add.setAddress(dto1.getAddress());
			add.setCityLocality(dto1.getCityLocality());
			add.setDistrict(dto1.getDistrict());
			add.setState(dto1.getState());
			add.setPin(dto1.getPin());
			if(dto1.getAtype()!=null) {
				addtype=adrepo.findByName(dto1.getAtype().getName());
				add.setAtype(addtype);
			}
			add.setAtype(addtype);
			addresslist.add(add);
		}
		user.setAddress(addresslist);
		//----------------------------------------------------------------------------------
//		 BeanUtils.copyProperties(dto, user); 
//		 List<Address> address=new ArrayList<Address>();
//		 for(AddressDTO dto1:dto.getAddress()) {
//		  Address add=new Address(); 
//		  BeanUtils.copyProperties(dto1, add);
//		  //add.setAddress_id(dto1.getAddress_id());
//		  System.out.println("dto obj address id value"+dto1.getAddress_id());
//		  address.add(add); 
//		  }
//		 InputStream is=new FileInputStream(dto.getPhotoadd());
//			byte[] photocontent=new byte[is.available()];
//			is.read(photocontent);
//			user.setPhoto(photocontent);
//		 user.setAddress(address);
//	
//		//save user using updated value
	   User user1=urepo.save(user);
		if(user1!=null) {
			return "User with id "+user1.getUid()+" updated";
		}else {
		return "Problem in record updation";
		}
		//return null;
	}

}
