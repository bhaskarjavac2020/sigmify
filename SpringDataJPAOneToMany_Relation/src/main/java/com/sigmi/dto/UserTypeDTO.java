package com.sigmi.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class UserTypeDTO implements Serializable {
	private Integer uid;
	private String utype;
	private String udesc;
}
