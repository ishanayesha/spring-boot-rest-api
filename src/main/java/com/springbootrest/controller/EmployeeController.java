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
import com.springbootrest.model.Task;
import com.springbootrest.service.EmployeeService;
import com.springbootrest.service.RoleSerivce;
import com.springbootrest.service.TaskSerivce;


@RestController
@RequestMapping(value="/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	@Autowired
	private RoleSerivce roleService;
	@Autowired
	private TaskSerivce taskService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Void> addEmp(@RequestBody EmployeeRole empRole)
	{
		//System.out.println(name + " saman kumara");
		Employee e=new Employee();
		e.setRole(roleService.getRoleById(empRole.getRoleId()));
		e.setName(empRole.getName());
		
		empService.add(e);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.CREATED);
	}

	@RequestMapping(value="/updateRole",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Void> updateEmpRole(@RequestBody EmployeeRole empRole)
	{
		Employee e=empService.getEmpById(empRole.getId());
		e.setRole(roleService.getRoleById(empRole.getRoleId()));
		
		empService.updateEmp(e);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.CREATED);
	}	

	@RequestMapping(value="/assignTask",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Void> assignTask(@RequestBody EmployeeTask empTask)
	{
		Employee e=empService.getEmpById(empTask.getId());
		Task task=taskService.getTaskById(empTask.getTaskId());
		task.setEmp(e);
		System.out.println("task"+empTask.getTaskId()+"emp"+empTask.getId());
		
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
