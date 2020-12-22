package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.iceb.beans.ReactionType;
import dev.iceb.utils.HibernateUtil;

public class ReactionTypeHibernate implements ReactionTypeDAO {

	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	@Override
	public ReactionType add(ReactionType t) {
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
	public ReactionType getById(Integer id) {
		Session s = hu.getSession();
		ReactionType c = s.get(ReactionType.class,  id);
		s.close();
		return c;
	}
	
	@Override
	public Set<ReactionType> getAll() {
		Session s = hu.getSession();
		String query = "FROM ReactionType";
		//query.Query
		Query<ReactionType> q = s.createQuery(query, ReactionType.class);
		List<ReactionType> pList = q.getResultList();
		Set<ReactionType> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}
	
	@Override
	public void update(ReactionType t) {
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
	public void delete(ReactionType t) {
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
