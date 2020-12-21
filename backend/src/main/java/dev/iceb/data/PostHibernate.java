package dev.iceb.data;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.iceb.utils.HibernateUtil;

import dev.iceb.beans.Post;

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
		Post post = s.get(Post.class, id);
		s.close();
		return post;
	}

	public Set<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Post t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Post t) {
		// TODO Auto-generated method stub
		
	}

	public Post getByUserId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Post getByUsername(String u) {
		// TODO Auto-generated method stub
		return null;
	}
}
