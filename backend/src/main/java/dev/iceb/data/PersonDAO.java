package dev.iceb.data;

import dev.iceb.beans.Person;

public interface PersonDAO extends GenericDAO<Person>{
	public Person getByUsername(String username);
	

}
