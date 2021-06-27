package com.abhi.crud.service;

import java.util.List;

import com.abhi.crud.model.Employee;

public interface IEmployeeService {

	// INSERT Employee
	public Employee insertEmployee(Employee employee) throws Exception;

	// GET EMPLOYEE
	public List<Employee> retrieveAllEmployees() throws Exception;

	// GET EMPLOYEE BY ID

	public Employee retrieveEmployeeByCode(String empCode) throws Exception;

	// DELETE Employee

	public int removeEmployee(String code) throws Exception;

	// UPDATE Employee
	public int modifyEmployee(Employee employee,String empCode) throws Exception;

	// EMAIL ALREADY EXISTS

	public int emailAlreadyExists(Employee employee) throws Exception;

	// MOBILE NO ALREADY EXISTS

	public int mobileNoAlreadyExists(Employee employee) throws Exception;
	
	//Validate Employee
	public boolean validateEmployee(String email,String password)throws Exception;

}
