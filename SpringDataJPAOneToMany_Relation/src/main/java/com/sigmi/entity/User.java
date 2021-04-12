package com.sigmi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sigmi.dto.AddressDTO;

import lombok.Data;
@Data
@Entity
@Table(name = "User_map")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String fname;
	private String lname;
	private Long phone;
	private String email;
	 @Lob 
	 private byte[] photo; 
	 private String password;
	private String repeatPassword;
	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",referencedColumnName = "id")
	//@JoinColumn(name="user_type_id",referencedColumnName = "id")
	private List<Address> address;
	@ManyToOne(targetEntity = UserType.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="userTypeId",referencedColumnName = "uid")
	private UserType utype;
	
 
}
