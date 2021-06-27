package com.abhi.crud.model;

import lombok.Data;

@Data
public class Employee {
	

	private Long employeeId;
	private String code;
	private String name;
	private String password;
	private String email;
	private Long mobileNumber;
	private String address;
}
