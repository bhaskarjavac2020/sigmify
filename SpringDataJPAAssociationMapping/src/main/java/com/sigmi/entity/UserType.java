package com.sigmi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "user_type")
public class UserType implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	//@Column(unique = true)
	private String name;
	private String description;
//	@OneToMany(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	//@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name = "userTypeId",referencedColumnName = "id")
//	private List<User> user;
   //private User user;
}
