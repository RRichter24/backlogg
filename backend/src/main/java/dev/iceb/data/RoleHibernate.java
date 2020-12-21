package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.iceb.beans.Role;
import dev.iceb.utils.HibernateUtil;

public class RoleHibernate implements RoleDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	@Override
	public Role add(Role t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
		return t;
	}
	@Override
	public Role getById(Integer id) {
		Session s = hu.getSession();
		Role c = s.get(Role.class,  id);
		s.close();
		return c;
	}
	@Override
	public Set<Role> getAll() {
		Session s = hu.getSession();
		String query = "FROM Role";
		//query.Query
		Query<Role> q = s.createQuery(query, Role.class);
		List<Role> pList = q.getResultList();
		Set<Role> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}
	@Override
	public void update(Role t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		} catch(Exception e) { //end try
			if(tx !=null) {
				tx.rollback();
			} //end if
		}finally { //end catch
			s.close();
		}//end finally 		
	}
@Override
	public void delete(Role t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
		}catch(Exception e) { //end try
			if(tx != null) {
				tx.rollback();
			}//end if
		}finally { //end catch
			s.close();
		}//end finally		
	}


}
