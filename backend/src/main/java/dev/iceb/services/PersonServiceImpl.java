package dev.iceb.services;

import dev.iceb.beans.Person;
import dev.iceb.data.PersonDAO;
import dev.iceb.data.PersonDAOFactory;

public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO; 
	
	public PersonServiceImpl() {
		PersonDAOFactory personDAOFactory = new PersonDAOFactory(); 
		personDAO = personDAOFactory.getPersonDAO(); 
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
	
	

}
