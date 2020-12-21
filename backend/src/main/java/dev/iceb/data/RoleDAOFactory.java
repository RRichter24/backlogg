package dev.iceb.data;

public class RoleDAOFactory {
	
	public RoleDAO getRoleDAO() {
		return new RoleHibernate();
	}
}
