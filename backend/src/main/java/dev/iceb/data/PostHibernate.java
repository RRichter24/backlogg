package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.iceb.utils.HibernateUtil;

import dev.iceb.beans.Post;
import dev.iceb.beans.Role;

public class PostHibernate implements PostDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	public Post add(Post t) {
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

	public Post getById(Integer id) {
		Session s = hu.getSession();
		Post c = s.get(Post.class,  id);
		s.close();
		return c;
	}

	public Set<Post> getAll() {
		Session s = hu.getSession();
		String query = "FROM Post";
		//query.Query
		Query<Post> q = s.createQuery(query, Post.class);
		List<Post> pList = q.getResultList();
		Set<Post> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}

	public void update(Post t) {
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

	public void delete(Post t) {
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

	public Set<Post> getByUserId(Integer id) {
		Session s = hu.getSession();
		String query = "FROM Post where person_id=:id";
		//query.Query
		Query<Post> q = s.createQuery(query, Post.class);
		q.setParameter("id", id);
		List<Post> pList = q.getResultList();
		Set<Post> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}

	public Set<Post> getByUsername(String u) {
		// TODO Auto-generated method stub
		return null;
	}
}
