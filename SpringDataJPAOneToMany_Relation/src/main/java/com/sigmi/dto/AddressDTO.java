
  package com.sigmi.dto;
  
  import java.io.Serializable;
  
  import org.springframework.stereotype.Component;

import com.sigmi.entity.AddressType;

import lombok.Data;
  
  @Data
  
  @Component 
  public class AddressDTO implements Serializable{ 
	  private Integer address_id; 
	  private String address; 
	  private String cityLocality; 
	  private String district; 
	  private String state; 
	  private Integer pin; 
	  private UserDTO dto;
	  private AddressType atype;
	  
  }
 