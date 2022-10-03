package com.deevyanshu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deevyanshu.entity.Employee;
import com.deevyanshu.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getAllEmployee()
	{
		return repository.findAll();
	}
	
	public Employee addEmployee(Employee emp,int dept_id)
	{
		emp.setDept_id(dept_id);
		return repository.save(emp);
	}
	
	public List<Employee> getEmployeeByDepartment(int dept_id)
	{
		List<Employee> list=getAllEmployee();
		List<Employee> em=new ArrayList<>();
		for(Employee e:list)
		{
			if(e.getDept_id()==dept_id)
			{
				em.add(e);
			}
		}
		return em;
	}
	

}
