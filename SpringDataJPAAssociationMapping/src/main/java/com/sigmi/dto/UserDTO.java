package com.sigmi.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sigmi.entity.UserType;

import lombok.Data;
@Data
@Component
public class UserDTO implements Serializable {
	private Integer uid;
	  private String fname; 
	  private String lname; 
	  private Long phone; 
	  private String email; 
	  private String photoadd;
	  private String password;
	  private List<AddressDTO> address;
	  private UserTypeDTO utype;
}
