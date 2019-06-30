package com.djangotest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.djangotest.model.Employee;
import com.djangotest.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Value("${spring.application.name}")
    String appName;
	
	@GetMapping
    public ModelAndView findAll() {
		final List<Employee> employees = employeeService.findAll();
		ModelAndView mv = new ModelAndView("/employee");
		mv.addObject("employees", employees);
		return mv;
    }
	
	@GetMapping("/add")
	public ModelAndView add(Employee employee) {
		ModelAndView mv = new ModelAndView("employeeAdd");
		mv.addObject("employee", employee);
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Employee employee, BindingResult result) {
		if(result.hasErrors()) {
			return add(employee);
		}
		employeeService.createEmployee(employee);
		return findAll();
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return findAll();
	}

}
