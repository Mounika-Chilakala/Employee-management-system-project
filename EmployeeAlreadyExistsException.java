package com.employee.app;

public class EmployeeAlreadyExistsException extends Exception{
	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}

}
