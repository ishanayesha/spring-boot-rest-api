package com.springbootrest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootrest.model.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(Role role) {
		getSession().save(role);
	}

	@Override
	public Role getRoleById(int id) {
		Role role=getSession().get(Role.class, id);
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRolelList() {
		List<Role> roleList=getSession().createQuery("from Role").list();
		return roleList;
	}

	@Override
	public void updateRole(Role role) {
		getSession().update(role);
	}

	@Override
	public void deleteRole(int id) {
		getSession().delete(getRoleById(id));
	}

}
