package com.sigmi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
//@Table(name="Address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer addrNo;

	private String address;
	
	private String city_locality;
	
	private String district;
	
	private String state;
	
	private Long pincode;
	
}
