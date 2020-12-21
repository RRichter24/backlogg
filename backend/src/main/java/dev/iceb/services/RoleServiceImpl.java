package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Role;
import dev.iceb.data.RoleDAO;
import dev.iceb.data.RoleDAOFactory;

public class RoleServiceImpl implements RoleService {
	private RoleDAO roleDao;
	
	public RoleServiceImpl() {
		RoleDAOFactory rdf = new RoleDAOFactory();
		roleDao = rdf.getRoleDAO();
	}
	@Override
	public Role addRole(Role p) {
		return roleDao.add(p);
	}

	@Override
	public Role getRoleById(Integer id) {
		return roleDao.getById(id);
	}

	@Override
	public Set<Role> getRoles() {
		return roleDao.getAll();
	}

	@Override
	public void updateRole(Role p) {
		roleDao.update(p);
	}

	@Override
	public void removeRole(Role p) {
		roleDao.delete(p);
	}

}
