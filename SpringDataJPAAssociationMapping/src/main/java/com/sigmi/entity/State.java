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

@Entity
@Table(name = "state")
public class State implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    //@Column(unique = true)
	private String name;
	private String description;
	@OneToMany(targetEntity = District.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="state_name",referencedColumnName = "name")
	@JoinColumn(name="state_id",referencedColumnName = "id")
	private List<District> districts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", description=" + description + ", districts=" + districts + "]";
	}
	
}
