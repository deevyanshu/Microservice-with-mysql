package com.deevyanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.entity.Department;
import com.deevyanshu.service.DepartmentService;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping("/allDepartments")
	public List<Department> getAllDepartment()
	{
		return service.getAllDepartment();
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") int id)
	{
		return service.getDepartmentById(id);
	}
	
	@PostMapping("/add")
	public Department addDepartment(@RequestBody Department dept)
	{
		return service.addDepartment(dept);
	}
}
