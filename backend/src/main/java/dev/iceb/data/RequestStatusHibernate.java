package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dev.iceb.beans.RequestStatus;
import dev.iceb.utils.HibernateUtil;

@Repository
public class RequestStatusHibernate implements RequestStatusDAO {

	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	@Override
	public RequestStatus add(RequestStatus t) {
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
	public RequestStatus getById(Integer id) {
		Session s = hu.getSession();
		RequestStatus c = s.get(RequestStatus.class,  id);
		s.close();
		return c;
	}
	
	@Override
	public Set<RequestStatus> getAll() {
		Session s = hu.getSession();
		String query = "FROM RequestStatus";
		//query.Query
		Query<RequestStatus> q = s.createQuery(query, RequestStatus.class);
		List<RequestStatus> pList = q.getResultList();
		Set<RequestStatus> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}
	
	@Override
	public void update(RequestStatus t) {
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
	public void delete(RequestStatus t) {
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
