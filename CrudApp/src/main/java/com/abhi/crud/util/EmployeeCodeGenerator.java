package com.abhi.crud.util;

import java.util.Random;

public class EmployeeCodeGenerator {

	public static String getCode() {
		String EMPLOYEE = "EMP";
		Random rd = new Random();

		int code = rd.nextInt(10000);
		return EMPLOYEE + code;

	}

	public static void main(String[] args) {
          
		System.out.println(EmployeeCodeGenerator.getCode());
	}

}
