package dev.iceb.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.iceb.beans.FriendRequest;
import dev.iceb.beans.Person;
import dev.iceb.beans.RequestStatus;
import dev.iceb.beans.FriendRequest;
import dev.iceb.beans.FriendRequest;
import dev.iceb.beans.FriendRequest;
import dev.iceb.data.FriendRequestDAO;
import dev.iceb.data.MessageDAO;

@ExtendWith(MockitoExtension.class)
public class FriendRequestServiceTest {
	
	@Mock
	static FriendRequestDAO fDao;
	
	@InjectMocks
	static FriendRequestServiceImpl fServ;
	
	static Set<FriendRequest> friendRequestMock = new HashSet<>();
	static Set<Person> personRequestMock = new HashSet<>();
	static Integer sequenceMock =1;
	
	
	@Test
	public void testGetFriendRequestById() {
		FriendRequest p = new FriendRequest();
		p.setId(35);
		friendRequestMock.add(p);
		
		when(fDao.getById(35)).thenReturn(p);
		assertEquals(p, fServ.getFriendRequestById(35));
		verify(fDao).getById(35);
	}
	
	@Test
	public void testAddFriendRequest() {
		FriendRequest p = new FriendRequest();
		p.setId(1);
		friendRequestMock.add(p);
		
		FriendRequest p2 = new FriendRequest();
		p2.setId(sequenceMock +=1);
		
		when(fDao.add(p)).thenReturn(p2);
		assertNotEquals(p.getId().intValue(), fServ.addFriendRequest(p).getId().intValue());
		verify(fDao).add(p);
		
	}
	
	@Test
	public void testUpdateFriendRequest() {
		FriendRequest p = new FriendRequest();
		fServ.updateFriendRequest(p);
		verify(fDao).update(p);
	}
	
	
	@Test
	public void testGetSentFriendRequest() {
		Person send = new Person();
		Person rec = new Person();
		send.setId(1);
		rec.setId(2);
		FriendRequest fr = new FriendRequest();
		fr.setId(1);
		fr.setPerson1_id(send.getId());
		fr.setPerson2_id(rec.getId());
		RequestStatus rs = new RequestStatus();
		rs.setId(1);
		rs.setName("pending");
		fr.setRequest_status(rs);
		friendRequestMock.add(fr);
		when(fServ.getSentFriendRequests(1)).thenReturn(friendRequestMock);
		assertEquals(friendRequestMock, fServ.getSentFriendRequests(1));
		assertNotEquals(friendRequestMock, fServ.getSentFriendRequests(2));
		verify(fDao).getSentRequests(1);
		verify(fDao).getSentRequests(2);
	
	}
	
	
	@Test
	public void testGetRecFriendRequest() {
		Person send = new Person();
		Person rec = new Person();
		send.setId(1);
		rec.setId(2);
		FriendRequest fr = new FriendRequest();
		fr.setId(1);
		fr.setPerson1_id(send.getId());
		fr.setPerson2_id(rec.getId());
		RequestStatus rs = new RequestStatus();
		rs.setId(1);
		rs.setName("pending");
		fr.setRequest_status(rs);
		friendRequestMock.add(fr);
		when(fServ.getReceivedFriendRequests(2)).thenReturn(friendRequestMock);
		assertEquals(friendRequestMock, fServ.getReceivedFriendRequests(2));
		assertNotEquals(friendRequestMock, fServ.getReceivedFriendRequests(1));
		verify(fDao).getReceivedRequests(1);
		verify(fDao).getReceivedRequests(2);
	
	}
	
	
	public void testGetFriendsList() {
		Person p = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		p.setId(1);
		p2.setId(2);
		p3.setId(3);
		FriendRequest fr = new FriendRequest();
		fr.setPerson1_id(p.getId());
		fr.setPerson2_id(p2.getId());
		friendRequestMock.add(fr);
		personRequestMock.add(p);
		personRequestMock.add(p2);
		when(fServ.getFriendsList(1)).thenReturn(personRequestMock);
		when(fServ.getFriendsList(2)).thenReturn(personRequestMock);
		assertEquals(personRequestMock, fServ.getFriendsList(1));
		assertEquals(personRequestMock, fServ.getFriendsList(2));
		assertNull(fServ.getFriendsList(3));
		verify(fDao).getUserFriendsList(1);
		verify(fDao).getUserFriendsList(2);
		verify(fDao).getUserFriendsList(3);
	}
}	
