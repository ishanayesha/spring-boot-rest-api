package com.springbootrest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootrest.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	// @PersistenceContext
	// private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }	
	
	@Override
	public void add(Employee emp) {
		//entityManager.persist(emp);
		getSession().save(emp);
	}

	@Override
	public Employee getEmpById(int id) {
		Employee emp=getSession().get(Employee.class, id);
		return emp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmplList() {
		return getSession().createQuery("FROM Employee").list();
	}

	@Override
	public void updateEmp(Employee emp) {
		getSession().update(emp);
	}

	@Override
	public void deleteEmp(int id) {
		getSession().delete(getEmpById(id));
	}
	


}
