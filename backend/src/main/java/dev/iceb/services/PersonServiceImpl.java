package dev.iceb.services;

import dev.iceb.beans.Person;
import dev.iceb.data.PersonDAO;
import dev.iceb.data.PersonDAOFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO; 
	
	@Autowired
	public PersonServiceImpl(PersonDAO pDAO) {
		personDAO = pDAO;
	}
	
	public Person add(Person p) {
		return personDAO.add(p); 
	}

	public Person getById(Integer id) {
		return personDAO.getById(id);
	}

	public Person getByUsername(String username) {
		return personDAO.getByUsername(username);
	}

	//TODO: change this to really reflect
	//updated user by changes in database
	@Override
	public Person update(Person p) {
		personDAO.update(p);
		return p;
	}
	
	
	
	

}
