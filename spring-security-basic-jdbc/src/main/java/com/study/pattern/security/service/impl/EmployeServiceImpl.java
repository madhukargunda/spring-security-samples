package com.study.pattern.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.study.pattern.security.domain.Employee;
import com.study.pattern.security.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {
	
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	public Employee getDummyEmployee() {			
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}
	

	public  Employee getEmployee( int empId){					
		return empData.get(empId);
	}
	

	public List<Employee> getAllEmployees() {		
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			emps.add(empData.get(i));
		}
		return emps;
	}
	

	public Employee createEmployee(@RequestBody Employee emp) {			
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}
	

	public Employee deleteEmployee(@PathVariable("id") int empId) {		
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}

}
