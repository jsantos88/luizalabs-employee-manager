package com.djangotest.service;

import java.util.List;

import com.djangotest.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee createEmployee(Employee employee);
	
	void delete(Long id);

}
