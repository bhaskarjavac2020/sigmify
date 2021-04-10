package com.sigmi.entity;

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

import lombok.Data;
@Data
@Entity
@Table(name = "User_map")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User{
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

	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private List<Address> address;
	
	@ManyToOne(targetEntity = UserType.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="userTypeId",referencedColumnName = "id")
	private UserType utype; 
}
