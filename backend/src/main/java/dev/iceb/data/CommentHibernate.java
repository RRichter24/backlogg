package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dev.iceb.beans.Comment;
import dev.iceb.utils.HibernateUtil;

@Repository
public class CommentHibernate implements CommentDAO {


	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	@Override
	public Comment add(Comment t) {
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
	public Comment getById(Integer id) {
		Session s = hu.getSession();
		Comment c = s.get(Comment.class,  id);
		s.close();
		return c;
	}
	
	@Override
	public Set<Comment> getAll() {
		Session s = hu.getSession();
		String query = "FROM Comment";
		//query.Query
		Query<Comment> q = s.createQuery(query, Comment.class);
		List<Comment> pList = q.getResultList();
		Set<Comment> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}
	
	@Override
	public void update(Comment t) {
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
	public void delete(Comment t) {
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
