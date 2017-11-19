package com.springbootrest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootrest.model.Task;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(Task task) {
		getSession().save(task);
	}

	@Override
	public Task getTaskById(int id) {
		Task task=getSession().get(Task.class, id);
		return task;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getTaskList() {
		List<Task> taskList=getSession().createQuery("from Task").list();
		return taskList;
	}

	@Override
	public void updateTask(Task task) {
		getSession().update(task);
	}

	@Override
	public void deleteTask(int id) {
		getSession().delete(getTaskById(id));
	}

}
