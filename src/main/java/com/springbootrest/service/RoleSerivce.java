package com.springbootrest.service;

import java.util.List;

import com.springbootrest.model.Role;

public interface RoleSerivce {

	public void add(Role role);
	public Role getRoleById(int id);
	public List<Role> getRolelList();
	public void updateRole(Role role);
	public void deleteRole(int id);		
}
