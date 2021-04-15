package com.sigmi.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Table(name = "address")
public class Address{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private String address;
    private String cityLocality;
    private String district;
    private String state;
    private Integer pin;
    @ManyToOne(targetEntity = User.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="user_Id",referencedColumnName = "id")
    private User user;
    @ManyToOne(targetEntity = AddressType.class,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="addressTypeId",referencedColumnName = "id")
    private AddressType addressType;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", cityLocality=" + cityLocality + ", district="
				+ district + ", state=" + state + ", pin=" + pin + ", user=" + user + ", addressType=" + addressType
				+ "]";
	}
    
}
