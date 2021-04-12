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
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@Entity
//@Table(name="user")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="fname")
	private String fname;	
	@Column(name="lname")
	private String lname;
	@Column(name="email")
	private String email;
	//@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)	
    @JoinColumn(name="user_id",referencedColumnName = "id")
	private List<Address> addrs;
}
