package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Role;
import dev.iceb.data.RoleDAO;
import dev.iceb.data.RoleDAOFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	private RoleDAO roleDao;
	
	@Autowired
	public RoleServiceImpl(RoleDAO rDAO) {
		roleDao = rDAO;
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
