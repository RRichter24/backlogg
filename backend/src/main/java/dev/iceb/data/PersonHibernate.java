package dev.iceb.data;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.iceb.beans.Person;
import dev.iceb.utils.HibernateUtil;

public class PersonHibernate implements PersonDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	public Person add(Person t) {
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

	public Set<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Person t) {
		// TODO Auto-generated method stub

	}

	public void delete(Person t) {
		// TODO Auto-generated method stub

	}

	public Person getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Person getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
