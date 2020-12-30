package dev.iceb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.iceb.beans.Person;
import dev.iceb.beans.Person;
import dev.iceb.data.PersonDAO;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	@Mock
	static PersonDAO pDao;
	
	@InjectMocks
	static PersonServiceImpl pServ;
	
	static Set<Person> personMock = new HashSet<>();
	static Integer sequenceMock = 1;
	
	
	@Test
	public void testCheckLogin() {
		Person p = new Person();
		p.setUsername("user");
		p.setPasswd("pass");
		personMock.add(p);
		
		when(pDao.getByUsername("user")).thenReturn(p);
		assertEquals(p, pServ.getByUsername("user"));
		verify(pDao).getByUsername("user");
	}
	
	@Test
	public void testGetPersonById() {
		Person p = new Person();
		p.setId(35);
		personMock.add(p);
		
		when(pDao.getById(35)).thenReturn(p);
		assertEquals(p, pServ.getById(35));
		verify(pDao).getById(35);
		personMock.remove(p);
	}
	
	@Test
	public void testUpdatePerson() {
		Person p = new Person();
		pServ.update(p);
		verify(pDao).update(p);
	}
	
	@Test
	public void testGetPersonByUsername() {
		Person p = new Person();
		p.setUsername("user");
		personMock.add(p);
		
		when(pDao.getByUsername("user")).thenReturn(p);
		assertEquals(p, pServ.getByUsername("user"));
		verify(pDao).getByUsername("user");
		personMock.remove(p);
	}
}
