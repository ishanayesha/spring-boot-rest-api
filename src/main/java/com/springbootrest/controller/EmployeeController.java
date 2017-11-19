package com.springbootrest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.model.Employee;
import com.springbootrest.service.EmployeeService;
import com.springbootrest.service.RoleSerivce;


@RestController
@RequestMapping(value="/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	@Autowired
	private RoleSerivce roleService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Void> addEmp(@RequestBody Employee emp)
	{
  
		emp.setRole(roleService.getRoleById(1));

		empService.add(emp);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public ResponseEntity<Void> removeEmp(@PathVariable("id") int id)
	{
		empService.deleteEmp(id);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/update",method=RequestMethod.PUT,headers="Accept=application/json")
	public ResponseEntity<Void> updateEmp(@RequestBody Employee emp)
	{
		empService.updateEmp(emp);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.OK);
	}	
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Employee> getEmp(@PathVariable int id)
	{
		Employee emp=empService.getEmpById(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/list",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Employee>> getAllEmp()
	{
		List<Employee> empList=empService.getEmplList();

		if(empList.size()==0)
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}	
}
