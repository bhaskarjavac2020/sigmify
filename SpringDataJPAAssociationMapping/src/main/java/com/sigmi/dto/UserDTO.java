package com.sigmi.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sigmi.entity.UserType;

import lombok.Data;

@Component
public class UserDTO implements Serializable {
	private Integer id;
	  private String fname; 
	  private String lname; 
	  private Long phone; 
	  private String email; 
	  private String photoadd;
	  private String password;
	  private List<AddressDTO> addressdto;
	  private UserTypeDTO udtype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhotoadd() {
		return photoadd;
	}
	public void setPhotoadd(String photoadd) {
		this.photoadd = photoadd;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AddressDTO> getAddressdto() {
		return addressdto;
	}
	public void setAddressdto(List<AddressDTO> addressdto) {
		this.addressdto = addressdto;
	}
	public UserTypeDTO getUdtype() {
		return udtype;
	}
	public void setUdtype(UserTypeDTO udtype) {
		this.udtype = udtype;
	}
	  
}
