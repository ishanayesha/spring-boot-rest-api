package com.springbootrest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.dao.TaskDao;
import com.springbootrest.model.Task;

@Service
public class TaskSerivceImpl implements TaskSerivce{

	@Autowired
	private TaskDao taskDao;

	@Override
	public void add(Task task) {
		taskDao.add(task);
	}

	@Override
	public Task getTaskById(int id) {
		return taskDao.getTaskById(id);
	}

	@Override
	public List<Task> getTaskList() {
		return taskDao.getTaskList();
	}

	@Override
	public void updateTask(Task task) {
		taskDao.updateTask(task);
	}

	@Override
	public void deleteTask(int id) {
		taskDao.deleteTask(id);
	}
	
	

}
