package dev.iceb.data;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.iceb.beans.Image;
import dev.iceb.utils.HibernateUtil;

public class ImageHibernate implements ImageDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Image add(Image t) {
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
	public Image getById(Integer id) {
		Session s = hu.getSession();
		Image c = s.get(Image.class, id);
		s.close();
		return c;
	}

	@Override
	public Set<Image> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Image t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		} catch(Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
		}finally {
			s.close();
		} 

	}

	@Override
	public void delete(Image t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getByPostId(Integer pid) {
		Image img = null;

		try (Session s = hu.getSession()) {
			s.beginTransaction();
			String hql = "FROM Image WHERE post_id = :post_id";
			Query<Image> q = s.createQuery(hql, Image.class);
			q.setParameter("post_id", pid);
			img = q.getResultList().get(0); 
		} catch (Exception e) {
			e.printStackTrace();
			throw e; 
		}
		return img; 
	}

}
