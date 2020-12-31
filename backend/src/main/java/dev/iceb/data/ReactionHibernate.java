package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dev.iceb.beans.Reaction;
import dev.iceb.beans.Reaction;
import dev.iceb.utils.HibernateUtil;

@Repository
public class ReactionHibernate implements ReactionDAO{

	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	@Override
	public Reaction add(Reaction t) {
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
	public Reaction getById(Integer id) {
		Session s = hu.getSession();
		Reaction c = s.get(Reaction.class,  id);
		s.close();
		return c;
	}
	
	@Override
	public Set<Reaction> getAll() {
		Session s = hu.getSession();
		String query = "FROM Reaction";
		//query.Query
		Query<Reaction> q = s.createQuery(query, Reaction.class);
		List<Reaction> pList = q.getResultList();
		Set<Reaction> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}
	
	@Override
	public void update(Reaction t) {
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
	public void delete(Reaction t) {
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
	
	@Override
	public Set<Reaction> getByPostId(Integer pid) {
		try (Session s = hu.getSession()) {
			s.beginTransaction();
			String hql = "FROM Reaction WHERE post_id = :post_id";
			Query<Reaction> q = s.createQuery(hql, Reaction.class);
			q.setParameter("post_id", pid);
			List<Reaction> pList = q.getResultList();
			Set<Reaction> pSet = new HashSet<>();
			pSet.addAll(pList); 
			return pSet; 
		} catch (Exception e) {
			e.printStackTrace();
			throw e; 
		} 
	}
}
