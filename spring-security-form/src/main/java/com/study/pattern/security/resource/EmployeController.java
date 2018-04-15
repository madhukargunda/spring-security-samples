package com.study.pattern.security.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.pattern.security.constants.EmpRestURIConstants;
import com.study.pattern.security.domain.Employee;

@RestController
public class EmployeController{
	
		
		//Map to store employees, ideally we should use database
		Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
		
		@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
		public @ResponseBody Employee getDummyEmployee() {			
			Employee emp = new Employee();
			emp.setId(9999);
			emp.setName("Dummy");
			emp.setCreatedDate(new Date());
			empData.put(9999, emp);
			return emp;
		}
		
		@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
		public @ResponseBody Employee getEmployee(@PathVariable("id") int empId){					
			return empData.get(empId);
		}
		
		@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
		public @ResponseBody List<Employee> getAllEmployees() {		
			List<Employee> emps = new ArrayList<Employee>();
			Set<Integer> empIdKeys = empData.keySet();
			for(Integer i : empIdKeys){
				emps.add(empData.get(i));
			}
			return emps;
		}
		
		@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
		public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {			
			emp.setCreatedDate(new Date());
			empData.put(emp.getId(), emp);
			return emp;
		}
		
		@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
		public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {		
			Employee emp = empData.get(empId);
			empData.remove(empId);
			return emp;
		}
		
	}

