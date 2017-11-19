package com.springbootrest.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.dao.EmployeeDao;
import com.springbootrest.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public void add(Employee emp) {
		empDao.add(emp);
	}

	@Override
	public Employee getEmpById(int id) {
		return empDao.getEmpById(id);
	}

	@Override
	public List<Employee> getEmplList() {
		return empDao.getEmplList();
	}

	@Override
	public void updateEmp(Employee emp) {
		empDao.updateEmp(emp);
	}

	@Override
	public void deleteEmp(int id) {
		empDao.deleteEmp(id);
	}


	


}
