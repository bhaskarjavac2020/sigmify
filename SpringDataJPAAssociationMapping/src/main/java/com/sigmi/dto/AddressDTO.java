package com.sigmi.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sigmi.entity.AddressType;

import lombok.Data;

@Component
public class AddressDTO implements Serializable {
	  private Integer id; 
	  private String address; 
	  private String cityLocality; 
	  private String district; 
	  private String state; 
	  private Integer pin; 
	  private Integer userDdtoId;
	  private AddressTypeDTO atypedto;
	  private boolean delete;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCityLocality() {
		return cityLocality;
	}
	public void setCityLocality(String cityLocality) {
		this.cityLocality = cityLocality;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public Integer getUserDdtoId() {
		return userDdtoId;
	}
	public void setUserDdtoId(Integer userDdtoId) {
		this.userDdtoId = userDdtoId;
	}
	public AddressTypeDTO getAtypedto() {
		return atypedto;
	}
	public void setAtypedto(AddressTypeDTO atypedto) {
		this.atypedto = atypedto;
	}
	  
}
