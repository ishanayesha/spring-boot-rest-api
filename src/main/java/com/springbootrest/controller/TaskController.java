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

import com.springbootrest.model.Task;
import com.springbootrest.service.TaskSerivce;


@RestController
@RequestMapping(value="/task")
public class TaskController {

	@Autowired
	private TaskSerivce taskService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Void> addTask(@RequestBody Task task)
	{
		taskService.add(task);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> removeTask(@PathVariable("id") int id)
	{
		taskService.deleteTask(id);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateTask(@RequestBody Task task)
	{
		taskService.updateTask(task);
		HttpHeaders header=new HttpHeaders();
		return new ResponseEntity<Void>(header,HttpStatus.OK);
	}	
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public ResponseEntity<Task> getTask(@PathVariable int id)
	{
		Task task=taskService.getTaskById(id);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ResponseEntity<List<Task>> getAllTask()
	{
		List<Task> taskList=taskService.getTaskList();

		if(taskList.size()==0)
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);
	}	
}
