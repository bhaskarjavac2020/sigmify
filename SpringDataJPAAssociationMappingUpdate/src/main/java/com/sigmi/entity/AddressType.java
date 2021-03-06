package com.sigmi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
//@Table(name = "address_type")
@Table(name = "addresstype")
public class AddressType {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String name;
private String description;
}
