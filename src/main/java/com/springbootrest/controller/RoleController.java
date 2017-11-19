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

import com.springbootrest.model.Role;
import com.springbootrest.service.RoleSerivce;


@RestController
@RequestMapping(value="/role")
public class RoleController {

	@Autowired
	private RoleSerivce roleService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Void> addRole(@RequestBody Role role)
	{
		roleService.add(role);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> removeRole(@PathVariable("id") int id)
	{
		roleService.deleteRole(id);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateRole(@RequestBody Role role)
	{
		roleService.updateRole(role);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.OK);
	}	
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public ResponseEntity<Role> getRole(@PathVariable int id)
	{
		Role role=roleService.getRoleById(id);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ResponseEntity<List<Role>> getAllRole()
	{
		List<Role> roleList=roleService.getRolelList();

		if(roleList.size()==0)
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Role>>(roleList,HttpStatus.OK);
	}	
}
