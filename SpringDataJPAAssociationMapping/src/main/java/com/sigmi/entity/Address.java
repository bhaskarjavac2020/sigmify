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

@Data
@Entity
@Table(name = "Address_map")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer address_id;
    private String address;
    private String cityLocality;
    private String district;
    private String state;
    private Integer pin;
    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="user_Id",referencedColumnName = "id")
    private User user;
    @ManyToOne(targetEntity = AddressType.class,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="addressTypeId",referencedColumnName = "id")
    private AddressType atype;
}
