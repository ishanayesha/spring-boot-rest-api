package com.springbootrest.dao;

import java.util.List;

import com.springbootrest.model.Role;

public interface RoleDao {

	public void add(Role role);
	public Role getRoleById(int id);
	public List<Role> getRolelList();
	public void updateRole(Role role);
	public void deleteRole(int id);	
}
