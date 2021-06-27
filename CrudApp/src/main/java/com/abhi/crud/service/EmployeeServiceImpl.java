package com.abhi.crud.service;

import java.util.List;

import com.abhi.crud.dao.EmployeeDaoImpl;
import com.abhi.crud.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	private EmployeeDaoImpl employeeDaoImpl;

	public EmployeeServiceImpl() {
		employeeDaoImpl = new EmployeeDaoImpl();
	}

	@Override
	public Employee insertEmployee(Employee employee) throws Exception {
		return employeeDaoImpl.saveEmployee(employee);
	}

	@Override
	public List<Employee> retrieveAllEmployees() throws Exception {
		return employeeDaoImpl.getAllEmployees();
	}

	@Override
	public Employee retrieveEmployeeByCode(String empCode) throws Exception {
		return employeeDaoImpl.getEmployeeByCode(empCode);
	}

	@Override
	public int removeEmployee(String code) throws Exception {
		return employeeDaoImpl.deleteEmployee(code);
	}

	@Override
	public int modifyEmployee(Employee employee,String empCode) throws Exception {
		
		return employeeDaoImpl.updateEmployee(employee, empCode);
	}

	@Override
	public int emailAlreadyExists(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int mobileNoAlreadyExists(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validateEmployee(String email, String password) throws Exception {

		return  employeeDaoImpl.loginEmployee(email, password);
	}

}
