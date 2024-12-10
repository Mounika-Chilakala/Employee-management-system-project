package com.employee.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Client {
	public static void main(String[] args) {
		HashMap<Integer,Employee> employee=new HashMap<Integer,Employee>();
		Scanner sc=new Scanner(System.in);
		int empId=300;
		while(true) {
			System.out.println("****Employee Management System****");
			System.out.println("1.Add Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.Get Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.Get all Employees");
			try {
				int option=sc.nextInt();

				switch(option) {
				case 1:
					System.out.println("Adding Employee Details");
					System.out.println("Enter Employee name:");
					String empName=sc.next();
					System.out.println("Enter Employee salary:");
					int empSal=sc.nextInt();
					System.out.println("Enter Employee Address:");
					String empAdd=sc.next();
					System.out.println("Enter Employee MailId:");
					String empMail=sc.next();
					if(empName.isEmpty() || empSal<=0 || empAdd.isEmpty() || empMail.isEmpty()) {
						throw new InvalidEmployeeInput("Employee data is invalid");
					}
					if(employee.containsKey(empId)) {
						throw new EmployeeAlreadyExistsException("Employee "+empId+" is already exists");
					}
					
					Employee emp=new Employee(empName, empSal, empAdd, empMail);
					employee.put(empId++, emp);
					System.out.println("Employee Details added successfully:"+empId);
					break;
				case 2:
					System.out.println("Updating Employee Details");
					System.out.println("Enter the Employee id for updating:");
					int empid=sc.nextInt();
//					if(!employee.containsKey(empid)) {
//						throw new EmployeeNotFoundException("Employee "+empid+" is not found");
//					}
					System.out.println("Enter Employee name:");
					String empname=sc.next();
					System.out.println("Enter Employee salary:");
					int empsal=sc.nextInt();
					System.out.println("Enter Employee Address:");
					String empadd=sc.next();
					System.out.println("Enter Employee MailId:");
					String empmail=sc.next();
					Employee empupdate=new Employee(empname, empsal, empadd, empmail);
					employee.put(empid, empupdate);
					System.out.println("Employee Details updated successfully");
					
					break;
				case 3:
					System.out.println("Enter the Employee id to get details:");
					int empid1=sc.nextInt();
					if(!employee.containsKey(empid1)) {
						throw new EmployeeNotFoundException("Employee "+empid1+" is not found");
					}
					Employee empobj=employee.get(empid1);
					System.out.println(empobj);
					break;
				case 4:
					System.out.println("Deleting Employee Details");
					System.out.println("Enter employee id for deleting:");
					int empid2=sc.nextInt();
					if(!employee.containsKey(empid2)) {
						throw new EmployeeNotFoundException("Employee "+empid2+" is not found");
					}
					employee.remove(empid2);
					System.out.println("Employee "+empid2+" deleted successfully");
					break;
				case 5:
					System.out.println("Getting all employees details");
					Set<Entry<Integer,Employee>> result=employee.entrySet();
					if(result.isEmpty()) {
						throw new EmployeeNotFoundException("No employees found");
					}
					Iterator<Entry<Integer,Employee>> itr=result.iterator();
					while(itr.hasNext()) {
						Entry<Integer,Employee> finalResult=itr.next();
						System.out.println(finalResult.getKey()+" "+finalResult.getValue());
					}
					break;
				default:
					System.out.println("Please enter valid input");
					break;
				}
			}catch(Exception e) {
				System.out.println("Error:"+e.getMessage());
			}
		}

	}
}
