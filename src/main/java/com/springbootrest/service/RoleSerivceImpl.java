package com.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.dao.RoleDao;
import com.springbootrest.model.Role;

@Service
public class RoleSerivceImpl implements RoleSerivce{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public List<Role> getRolelList() {
		return roleDao.getRolelList();
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	@Override
	public void deleteRole(int id) {
		roleDao.deleteRole(id);
	}

}
