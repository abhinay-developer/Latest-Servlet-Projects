package com.abhi.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.abhi.crud.model.Employee;
import com.abhi.crud.service.EmployeeServiceImpl;
import com.abhi.crud.util.EmployeeCodeGenerator;

@WebServlet("/")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private EmployeeServiceImpl serviceImpl;
	RequestDispatcher rd = null;
	HttpSession session = null;

	public void init() {
		employee = new Employee();

		serviceImpl = new EmployeeServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String action = request.getServletPath();

		try {
			switch (action) {

			case "/register":
				insertEmp(request, response);
				break;
			case "/delete":
				deleteEmp(request, response);
				break;
			case "/update":
				updateEmp(request, response);
				break;
			case "/empByCode":
				getEmpByCode(request, response);
				break;

			default:
				listEmp(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void getEmpByCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		session = request.getSession();
		try {
			String code = request.getParameter("empCode");
			session.setAttribute("code", code);

			System.out.println(code);
			Employee emp = serviceImpl.retrieveEmployeeByCode(code);
			System.out.println(emp);
			if (emp != null) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("email", emp.getEmail());
				jsonObj.put("mobileNumber", emp.getMobileNumber());
				jsonObj.put("address", emp.getAddress());
				pw.write(jsonObj.toString());
				System.out.println("Details fectched ");

			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		String code = request.getParameter("empCode");
		try {
			int count = serviceImpl.removeEmployee(code);

			System.out.println(count);
			if (count != 0) {
				pw.write("Deleted Sucessfully");
			} else {
				pw.write("Failed to delete");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		employee.setCode(EmployeeCodeGenerator.getCode());
		employee.setName(request.getParameter("name"));
		employee.setPassword(request.getParameter("password"));
		employee.setEmail(request.getParameter("email"));
		employee.setMobileNumber(Long.parseLong(request.getParameter("mobileNo")));
		employee.setAddress(request.getParameter("address"));

		try {
			Employee emp = serviceImpl.insertEmployee(employee);

			if (emp != null) {
				pw.println("Employee Inserted Sucessfully");
				listEmp(request, response);
				rd = request.getRequestDispatcher("employeeInfo.jsp");
				rd.forward(request, response);

			} else {
				pw.println("Employee Registration Failed");
//				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
//				rd.forward(request, response);
			}

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		session = request.getSession();
		String code = (String) session.getAttribute("code");
		PrintWriter pw = response.getWriter();
		Employee employee = new Employee();
		employee.setEmail(request.getParameter("email"));
		employee.setMobileNumber(Long.parseLong(request.getParameter("mobileNumber")));
		employee.setAddress(request.getParameter("address"));

		try {
			int count = serviceImpl.modifyEmployee(employee, code);
			System.out.println(count);
			if (count != 0) {
				pw.write("updated sucessfully");
			} else {
				pw.write("Failed to update");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void listEmp(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			List<Employee> employees = serviceImpl.retrieveAllEmployees();
			request.setAttribute("employees", employees);
			rd = request.getRequestDispatcher("employeeInfo.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}
