package com.sigmi.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

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
import com.sigmi.repository.IAddressRepository;
import com.sigmi.repository.IAddressTypeRepository;
import com.sigmi.repository.IUserRepository;
import com.sigmi.repository.IUserTypeRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IAddressRepository addressRepo;
	@Autowired
	private IUserTypeRepository userTypeRepo;
	@Autowired
    private IAddressTypeRepository addressTypeRepo;
	@Override
	public Integer registreUser(UserDTO userDto) throws Exception {
		UserType userType=null;
		InputStream is=new FileInputStream(userDto.getPhotoadd());
		byte[] photocontent=new byte[is.available()];
		is.read(photocontent);
		User newUser= new User();
		newUser.setFname(userDto.getFname());
		newUser.setLname(userDto.getLname());
		newUser.setEmail(userDto.getEmail());
		newUser.setPhone(userDto.getPhone());
		newUser.setPhoto(photocontent);
		newUser.setPassword(userDto.getPassword());
		if (userDto.getUdtype()!=null) {
			userType=userTypeRepo.findByName(userDto.getUdtype().getName());
			}
		newUser.setUserType(userType);
		//set address for user
		List<Address> listAddress=new ArrayList<Address>();
		for (AddressDTO adrsDto : userDto.getAddressdto()) {
			Address adrs=new Address();
			adrs.setAddress(adrsDto.getAddress());
			adrs.setCityLocality(adrsDto.getCityLocality());
			adrs.setDistrict(adrsDto.getDistrict());
			adrs.setState(adrsDto.getState());
			adrs.setPin(adrsDto.getPin());
			AddressType addtype=null;
			if(adrsDto.getAtypedto()!=null) {
				addtype=addressTypeRepo.findByName(adrsDto.getAtypedto().getName());
				adrs.setAddressType(addtype);
			}
			adrs.setAddressType(addtype);
			listAddress.add(adrs);
		}
		newUser.setAddressess(listAddress);
		userRepo.save(newUser);
		return newUser.getId();
	}
//----------------get all user details------------------------
	@Override
	public List<UserDTO> fetchAllUser() throws Exception {
		List<UserDTO> listUserDto=new ArrayList<UserDTO>();
		List<User> listUser =userRepo.findAll();
		for(User user:listUser) {
			UserDTO userDto= new UserDTO();
			userDto.setId(user.getId());
			userDto.setFname(user.getFname());
			userDto.setFname(user.getFname());
			userDto.setLname(user.getLname());
			userDto.setPhone(user.getPhone());
			userDto.setPassword(user.getPassword());
			userDto.setEmail(user.getEmail());
			
			//-------convert photo----------
			userDto.setPhotoadd(Base64.getEncoder().encodeToString(user.getPhoto()));
			
			//----UserType-------
			UserTypeDTO utdto=new UserTypeDTO();
			utdto.setId(user.getUserType().getId());
			utdto.setName(user.getUserType().getName());
			utdto.setDescription(user.getUserType().getDescription());
			userDto.setUdtype(utdto);
			//-------Addressdto-----
			List<AddressDTO> listAddressDto=new ArrayList();
			for (Address adrs : user.getAddressess()) {
				AddressDTO adrsDto=new AddressDTO();
				//--------copy properties from address to addressdto
				adrsDto.setId(adrs.getId());
				adrsDto.setAddress(adrs.getAddress());
				adrsDto.setCityLocality(adrs.getCityLocality());
				adrsDto.setDistrict(adrs.getDistrict());
				adrsDto.setPin(adrs.getPin());
				adrsDto.setUserDdtoId(userDto.getId());
				AddressTypeDTO adrsTdto=new AddressTypeDTO();
				adrsTdto.setId(adrs.getAddressType().getId());
				adrsTdto.setName(adrs.getAddressType().getName());
				adrsTdto.setDescription(adrs.getAddressType().getDescription());
				adrsDto.setAtypedto(adrsTdto);
			}
			userDto.setAddressdto(listAddressDto);
			//----userdto to userdtolist
			listUserDto.add(userDto);
		}
		return listUserDto;
	}
//-------------------delete specific user---------------------------------------
	@Override
	public String deleteUser(Integer id) {
		if(userRepo.existsById(id)) {	
			   userRepo.deleteById(id);
			return "User with given id "+id+" removed";
		}else {
			return "invalid userid";
		}
		
	}
//-------------------delete specific address---------------------------------------	
	@Override
	public String deleteAddress(Integer id) {
		if(addressRepo.existsById(id)) {
			addressRepo.deleteById(id);
			return "Address with given id "+id+" removed";
		}else {
			return "invalid address id";
		}
	}
	//-------------------------------update specific user details-----------------------------------
	@Override
	public Integer updateUser(UserDTO userdto) throws Exception {
		User user1=fetchOneUserById(userdto.getId());
		user1.setId(userdto.getId());
		user1.setPhone(userdto.getPhone());
		user1.setEmail(userdto.getEmail());
		UserType usertype=null;
		if(userdto.getUdtype()!=null) {
			usertype=userTypeRepo.findByName(userdto.getUdtype().getName());
		}
		user1.setUserType(usertype);
		userRepo.save(user1);
		return user1.getId();
	}
	//----------fetch one user---
	@Override
	public User fetchOneUserById(Integer id) {
		Optional<User> opt=userRepo.findById(id);
		User user=null;
		if (opt.isPresent()) {
			user=opt.get();
		}
		return user;
	}
	@Override
	public Integer updateAddress(UserDTO userDto) {
		Optional<User> opt=userRepo.findById(userDto.getId());
		User user=null;
		if(opt.isPresent()) {
			user=opt.get();
		}
		List<Address> listadress=new ArrayList();
		for(AddressDTO adrsDto:userDto.getAddressdto()) {
			Address  addrs =null;
			if(adrsDto.getId()!=null) {
				Optional<Address> opt1=addressRepo.findById(adrsDto.getId());
				if(opt.isPresent()) {
					addrs=opt1.get();
					if(addrs!=null && adrsDto.isDelete()) {
						addressRepo.delete(addrs);
						continue;
					} 
					if(addrs!=null && adrsDto.getAddress()!=null) {
						addrs.setAddress(adrsDto.getAddress());
						addrs.setCityLocality(adrsDto.getCityLocality());
						addrs.setPin(adrsDto.getPin());
						addrs.setDistrict(adrsDto.getDistrict());
					}
				}
				
			}
			else {
			addrs=new Address();
			//copy properties from AddressDTO to Address 
			//BeanUtils.copyProperties(adrsDto, addrs);
			addrs.setAddress(adrsDto.getAddress());
			addrs.setCityLocality(adrsDto.getCityLocality());
			addrs.setDistrict(adrsDto.getDistrict());
			addrs.setState(adrsDto.getState());
			addrs.setPin(adrsDto.getPin());
			AddressType addtype=null;
			if(adrsDto.getAtypedto()!=null) {
				addtype=addressTypeRepo.findByName(adrsDto.getAtypedto().getName());
			}
			addrs.setAddressType(addtype);
			//add Address to AddressList
			listadress.add(addrs);
			
			}//else
			
          // addressRepo.save(addrs);
			
		}//for
		for(Address adrs1:user.getAddressess()) {
			listadress.add(adrs1);
		}
		user.setAddressess(listadress);
		userRepo.save(user);
		return user.getId();
	}
}
