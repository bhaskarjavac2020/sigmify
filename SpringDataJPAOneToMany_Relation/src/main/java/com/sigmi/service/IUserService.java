package com.sigmi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sigmi.dto.UserDTO;
import com.sigmi.entity.User;

public interface IUserService {
	public Integer registreUser(UserDTO dto)throws Exception;
	public List<User> fetchAllUser() throws Exception;
	public User fetchUserById(Integer id);
	public String deleteUser(Integer id);
	public String updateUser(UserDTO dto)throws Exception;
}
