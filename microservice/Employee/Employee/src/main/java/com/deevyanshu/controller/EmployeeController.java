package com.deevyanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.entity.Employee;
import com.deevyanshu.service.EmployeeService;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployee()
	{
		return service.getAllEmployee();
	}
	
	@PostMapping("/add/{id}")
	public Employee addEmployee(@RequestBody Employee emp,@PathVariable int id)
	{
		return service.addEmployee(emp, id);
	}
	
	@GetMapping("/allEmployees/{dept_id}")
	public List<Employee> getEmployeeByDepartment(@PathVariable int dept_id)
	{
		return service.getEmployeeByDepartment(dept_id);
	}
}
