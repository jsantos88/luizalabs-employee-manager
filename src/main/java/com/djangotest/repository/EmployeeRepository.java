package com.djangotest.repository;

import org.springframework.stereotype.Repository;

import com.djangotest.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
