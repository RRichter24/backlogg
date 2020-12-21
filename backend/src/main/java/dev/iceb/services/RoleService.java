package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Role;

public interface RoleService {
	// "create" method: returns the unique identifier of the added Cat
	public Role addRole(Role p);
	// "read" methods
	public Role getRoleById(Integer id);
	public Set<Role> getRoles();
	// "update" methods
	public void updateRole(Role p);
	// "delete" methods
	public void removeRole(Role p);
	
}
