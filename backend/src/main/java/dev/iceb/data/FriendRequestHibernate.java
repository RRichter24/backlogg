package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dev.iceb.beans.FriendRequest;
import dev.iceb.beans.Message;
import dev.iceb.utils.HibernateUtil;
@Repository
public class FriendRequestHibernate implements FriendRequestDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	@Override
	public FriendRequest add(FriendRequest t) {
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
	public FriendRequest getById(Integer id) {
		Session s = hu.getSession();
		FriendRequest c = s.get(FriendRequest.class,  id);
		s.close();
		return c;
	}
	
	@Override
	public Set<FriendRequest> getAll() {
		Session s = hu.getSession();
		String query = "FROM FriendRequest";
		//query.Query
		Query<FriendRequest> q = s.createQuery(query, FriendRequest.class);
		List<FriendRequest> pList = q.getResultList();
		Set<FriendRequest> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}
	
	@Override
	public void update(FriendRequest t) {
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
	public void delete(FriendRequest t) {
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
	public Set<FriendRequest> getSentRequests(Integer id) {
		Session s = hu.getSession();
		String query = "FROM FriendRequest Where (person1_id = :person1_id AND request_status_id = 1)";
		//query.Query
		Query<FriendRequest> q = s.createQuery(query, FriendRequest.class).setParameter("person1_id", id);
		List<FriendRequest> pList = q.getResultList();
		Set<FriendRequest> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}

	@Override
	public Set<FriendRequest> getReceivedRequests(Integer id) {
		Session s = hu.getSession();
		String query = "FROM FriendRequest Where person2_id = :person2_id and request_status_id = 1";
		//query.Query
		Query<FriendRequest> q = s.createQuery(query, FriendRequest.class).setParameter("person2_id", id);
		List<FriendRequest> pList = q.getResultList();
		Set<FriendRequest> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	}

	
}
