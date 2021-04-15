package com.sigmi.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
public class StateDTO implements Serializable {
	private Integer id;
	private String name;
	private String description;
	List<DistrictDTO> districtdtos;
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
	public List<DistrictDTO> getDistrictdtos() {
		return districtdtos;
	}
	public void setDistrictdtos(List<DistrictDTO> districtdtos) {
		this.districtdtos = districtdtos;
	}
	@Override
	public String toString() {
		return "StateDTO [id=" + id + ", name=" + name + ", description=" + description + ", districtdtos="
				+ districtdtos + "]";
	}
	
}
