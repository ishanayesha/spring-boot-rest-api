package com.springbootrest.service;

import java.util.List;


import com.springbootrest.model.Task;

public interface TaskSerivce {

	public void add(Task task);
	public Task getTaskById(int id);
	public List<Task> getTaskList();
	public void updateTask(Task task);
	public void deleteTask(int id);		
}
