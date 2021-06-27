package com.abhi.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abhi.crud.db.connection.DBConnection;
import com.abhi.crud.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	private static String INSERT_EMP = " INSERT INTO CRUD_EMP(CODE,NAME,PASSWORD ,EMAIL,MOBILE_NUMBER,ADDRESS) VALUES (?,?,?,?,?,?)";
	private static String GET_ALL_EMPS = "SELECT CODE,NAME,PASSWORD ,EMAIL,MOBILE_NUMBER,ADDRESS FROM CRUD_EMP";
	private static String LOGIN_EMP = "SELECT EMAIL,PASSWORD  FROM CRUD_EMP WHERE EMAIL=? AND PASSWORD=?";
	private static String DELETE_EMP = "DELETE FROM  CRUD_EMP WHERE CODE=?";
	private static String GET_EMP_BY_CODE = "SELECT EMAIL,MOBILE_NUMBER,ADDRESS FROM CRUD_EMP WHERE CODE=?";
	private static String UPDATE_EMP = "UPDATE  CRUD_EMP SET EMAIL=?,MOBILE_NUMBER=?,ADDRESS=? WHERE CODE=?";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int count = 0;
      // SELECT  EXECUTE QUERY   //NON SELECT EXECUTE UPDATE
	@Override
	public Employee saveEmployee(Employee employee) throws Exception {
		try {
			// creating Connection
			con = DBConnection.getConnection();
			ps = con.prepareStatement(INSERT_EMP);
			ps.setString(1, employee.getCode());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getEmail());
			ps.setLong(5, employee.getMobileNumber());
			ps.setString(6, employee.getAddress());

			// Executing the Query
			count = ps.executeUpdate();
			System.out.println("Count::" + count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc objs
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		} // finally
		return employee;
	}// saveEmployee(-)

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		try {
			List<Employee> empList = new ArrayList<Employee>();
			con = DBConnection.getConnection();
			ps = con.prepareStatement(GET_ALL_EMPS);           
			rs = ps.executeQuery();

			while (rs.next()) {
				Employee employee = new Employee();
//    	   CODE,NAME,PASSWORD ,EMAIL,MOBILE_NUMBER,ADDRESS

				employee.setCode(rs.getString("CODE"));

				employee.setName(rs.getString("NAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setEmail(rs.getString("EMAIL"));
				employee.setMobileNumber(rs.getLong("MOBILE_NUMBER"));
				employee.setAddress(rs.getString("ADDRESS"));
				empList.add(employee);

			}

			return empList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// getAllEmployees(-)

	@Override
	public Employee getEmployeeByCode(String empCode) throws Exception {
		Employee employee = new Employee();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(GET_EMP_BY_CODE);
			ps.setString(1, empCode);
			rs = ps.executeQuery();

			if (rs.next()) {
				employee.setEmail(rs.getString("EMAIL"));
				employee.setMobileNumber(rs.getLong("MOBILE_NUMBER"));
				employee.setAddress(rs.getString("ADDRESS"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;

	}// getEmployeeById(-)

	@Override
	public int deleteEmployee(String code) throws Exception {
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(DELETE_EMP);

			ps.setString(1, code);
			count = ps.executeUpdate();
			if (count != 0) {
				return count;
			} else {
				return count;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}// deleteEmployee(-)

	@Override
	public int updateEmployee(Employee employee, String empCode) throws Exception {
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(UPDATE_EMP);
			ps.setString(1, employee.getEmail());
			ps.setLong(2, employee.getMobileNumber());
			ps.setString(3, employee.getAddress());
			ps.setString(4, empCode);
			count = ps.executeUpdate();
			if (count != 0) {
				return count;
			} else {
				return count;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}// updateEmployee(-)

	@Override
	public int isEmailAlreadyExists(Employee employee) throws Exception {

		return 0;
	}// isEmailAlreadyExists(-)

	@Override
	public int isMobileNoAlreadyExists(Employee employee) throws Exception {

		return 0;
	}// isMobileNoAlreadyExists(-)

	@Override
	public boolean loginEmployee(String email, String password) throws Exception {
		boolean status = false;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(LOGIN_EMP);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			status = rs.next();
			System.out.println(status + "{LOGIN DAO}");

			return status;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}// class
