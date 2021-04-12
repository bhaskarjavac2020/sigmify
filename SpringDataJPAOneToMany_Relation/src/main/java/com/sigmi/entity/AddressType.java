package com.sigmi.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "address_type")
public class AddressType {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer aid;
private String atype;
private String description;
@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name = "addressTypeId",referencedColumnName = "aid")
private List<Address> address;
}
