package com.sigmi.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class DistrictDTO implements Serializable {
	private Integer id;
	private String name;
	private String description;
	private StateDTO statedto;
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
	public StateDTO getStatedto() {
		return statedto;
	}
	public void setStatedto(StateDTO statedto) {
		this.statedto = statedto;
	}
	@Override
	public String toString() {
		return "DistrictDTO [id=" + id + ", name=" + name + ", description=" + description + ", statedto=" + statedto
				+ "]";
	}
	
}
