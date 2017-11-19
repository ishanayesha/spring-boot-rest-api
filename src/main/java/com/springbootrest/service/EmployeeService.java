package com.springbootrest.service;

import java.util.List;

import com.springbootrest.model.Employee;

public interface EmployeeService {

	public void add(Employee emp);
	public Employee getEmpById(int id);
	public List<Employee> getEmplList();
	public void updateEmp(Employee emp);
	public void deleteEmp(int id);
}
