package com.sigmi.service;

import java.util.List;

import com.sigmi.dto.UserDTO;
import com.sigmi.entity.User;

public interface IUserService {
	public Integer registreUser(UserDTO dto)throws Exception;
	public List<UserDTO> fetchAllUser() throws Exception;
	public UserDTO fetchUserById(Integer id);
	public String deleteUser(Integer id);
	public String deleteAddress(Integer id);
	public String updateUser(UserDTO dto)throws Exception;

}
