package com.sigmi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "user_type")
public class UserType implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	//@Column(unique = true)
	private String utype;
	private String udesc;
	@OneToMany(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "userTypeId",referencedColumnName = "uid")
	private List<User> user;
}
