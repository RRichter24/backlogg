package dev.iceb.services;

import dev.iceb.beans.Person;

public interface PersonService {
	
	public Person add(Person p); 
	public Person getById(Integer id); 
	public Person getByUsername(String username);
	public Person update(Person p);
//	public void friendAccept(Integer person1_id, Integer person2_id);
}
