package com.abhi.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abhi.crud.service.EmployeeServiceImpl;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeServiceImpl employeeServiceImpl;
	String homeURL="home.jsp";
	public void init() {

		employeeServiceImpl = new EmployeeServiceImpl();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		//creating session Object
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			boolean status = employeeServiceImpl.validateEmployee(email, password);
			if (status == true) {
				session.setAttribute("username", email);
				request.setAttribute("email", email);
				System.out.println("Login Sucess");
				rd = request.getRequestDispatcher(homeURL);
				rd.forward(request, response);
				
			} else {
				System.out.println("Login Failed");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
