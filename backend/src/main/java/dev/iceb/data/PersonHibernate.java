package dev.iceb.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dev.iceb.beans.Person;
import dev.iceb.utils.HibernateUtil;

public class PersonHibernate implements PersonDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	@Override
	public Person add(Person t) throws NullPointerException {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();
		}catch(Exception e) { //end try
			if(tx != null)
				tx.rollback();
		}finally { //end catch
			s.close();
		}//end finally
		return t;
	}// end add

	@Override
	public Person getById(Integer id) throws NullPointerException {
		Session s = hu.getSession();
		Person c = s.get(Person.class,  id);
		s.close();
		return c;
	} //end getbyId


	@Override
	public Set<Person> getAll() {
		Session s = hu.getSession();
		String query = "FROM Person";
		//query.Query
		Query<Person> q = s.createQuery(query, Person.class);
		List<Person> pList = q.getResultList();
		Set<Person> pSet = new HashSet<>();
		pSet.addAll(pList);
		s.close();
		
		return pSet;
	} //end getAll

	@Override
	public void update(Person t) {
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
	public void delete(Person t) {
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
	}//end delete

	@Override
	public Person getByUsername(String username) {
			Person p = null;
			
			try (Session s = hu.getSession()) {
				s.beginTransaction();
				String hql = "FROM Person WHERE username = :username";
				Query<Person> q = s.createQuery(hql, Person.class);
				q.setParameter("username", username);
				List<Person> resultList = q.getResultList();
				System.out.println(resultList.size());
				if (resultList.size() > 0) p = resultList.get(0);
			} catch (Exception e) { //end try
				e.printStackTrace();
			}//end catch
			
			return p;
			
	}//end getbyusername
}