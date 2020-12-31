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

import dev.iceb.beans.Message;
import dev.iceb.beans.Person;
import dev.iceb.data.MessageDAO;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {
	@Mock
	static MessageDAO mDao;
	
	@InjectMocks
	static MessageServiceImpl mServ;
	
	
	static Set<Message> messageMock = new HashSet<>();
	static Integer sequenceMock =1;
	
	
	@Test
	public void testGetById() {
		Message p = new Message();
		p.setId(35);
		messageMock.add(p);
		
		when(mDao.getById(35)).thenReturn(p);
		assertEquals(p, mServ.getMessageById(35));
		verify(mDao).getById(35);
	}
	
	@Test
	public void testGetMessagesByUserId() {
		Person p = new Person();
		p.setId(1);
		Person p2 = new Person();
		p2.setId(2);
		Message m = new Message();
		m.setSender_id(p.getId());
		m.setReceiver_id(p2.getId());
		messageMock.add(m);
		when(mServ.getMessagesByUserId(1)).thenReturn(messageMock);
		when(mServ.getMessagesByUserId(2)).thenReturn(messageMock);
		assertEquals(messageMock, mServ.getMessagesByUserId(1));
		assertEquals(messageMock, mServ.getMessagesByUserId(2));
		verify(mDao).MessagesByUserId(1);
		verify(mDao).MessagesByUserId(2);
	}
	
	@Test
	public void testAddMessage() {
		Message p = new Message();
		p.setId(1);
		messageMock.add(p);
		
		Message p2 = new Message();
		p2.setId(sequenceMock +=1);
		
		when(mDao.add(p)).thenReturn(p2);
		assertNotEquals(p.getId().intValue(), mServ.addMessage(p).getId().intValue());
		verify(mDao).add(p);
		
	}
	
	@Test
	public void updateMessage() {
		Message p = new Message();
		mServ.updateMessage(p);
		verify(mDao).update(p);
	}
	
}
