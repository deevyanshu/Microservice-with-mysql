package com.deevyanshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deevyanshu.Repository.DepartmentRepository;
import com.deevyanshu.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Department> getAllDepartment()
	{
		
		//return repository.findAll();
		List<Department> list=repository.findAll();
		
		for(Department dept:list)
		{
			//dept.setEmployees(restTemplate.getForObject("http://localhost:9010/api/v1/employee/allEmployees/"+dept.getId(),List.class));
			dept.setEmployees(restTemplate.getForObject("http://employee-service/api/v1/employee/allEmployees/"+dept.getId(),List.class));
		}
		return list;
	}
	
	public Department getDepartmentById(int id)
	{
		
		Department dept= repository.findById(id).get();
		//dept.setEmployees(restTemplate.getForObject("http://localhost:9010/api/v1/employee/allEmployees/"+dept.getId(),List.class));
		dept.setEmployees(restTemplate.getForObject("http://employee-service/api/v1/employee/allEmployees/"+dept.getId(),List.class));
		return dept;
	}
	
	public Department addDepartment(Department dept)
	{
		return repository.save(dept);
	}
}
