package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.iceb.beans.Message;
import dev.iceb.utils.HibernateUtil;

public class MessageHibernate implements MessageDAO {

	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	@Override
	public Message add(Message t) {
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
	public Message getById(Integer id) {
		Session s = hu.getSession();
		Message c = s.get(Message.class,  id);
		s.close();
		return c;
	}
	@Override
	public Set<Message> getAll() {
		Session s = hu.getSession();
		String query = "FROM Message";
		//query.Query
		Query<Message> q = s.createQuery(query, Message.class);
		List<Message> pList = q.getResultList();
		Set<Message> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}
	@Override
	public void update(Message t) {
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
	public void delete(Message t) {
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
