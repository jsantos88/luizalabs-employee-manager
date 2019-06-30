package com.djangotest.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djangotest.model.Employee;
import com.djangotest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(final Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(final Long id) {
		
		final Employee employee = employeeRepository.findById(id).map(e -> {
			return e;
		}).orElseThrow(EntityNotFoundException::new);
		
		employeeRepository.delete(employee);
	}

}
