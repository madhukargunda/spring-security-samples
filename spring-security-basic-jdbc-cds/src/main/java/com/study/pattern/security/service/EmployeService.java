package com.study.pattern.security.service;

import java.util.List;

import com.study.pattern.security.domain.Employee;

public interface EmployeService {
	
	public Employee getDummyEmployee();
	public  Employee getEmployee( int empId);
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee emp);
	public Employee deleteEmployee(int empId);

}
