package com.abhi.crud.dao;

import java.util.List;

import com.abhi.crud.model.Employee;

public interface IEmployeeDao {

	// INSERT Employee
	public Employee saveEmployee(Employee employee) throws Exception;

	// GET EMPLOYEE
	public List<Employee> getAllEmployees() throws Exception;

	// GET EMPLOYEE BY Code

	public Employee getEmployeeByCode(String  empCode) throws Exception;

	// DELETE Employee

	public int deleteEmployee(String code) throws Exception;

	// UPDATE Employee
	public int updateEmployee(Employee employee,String empCode) throws Exception;

	// EMAIL ALREADY EXISTS

	public int isEmailAlreadyExists(Employee employee) throws Exception;

	// MOBILE NO ALREADY EXISTS

	public int isMobileNoAlreadyExists(Employee employee) throws Exception;

	//LOGIN USER
	public boolean loginEmployee(String email, String password) throws Exception;

}// interface
