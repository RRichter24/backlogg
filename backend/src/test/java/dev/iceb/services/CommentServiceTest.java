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

import dev.iceb.beans.Comment;
import dev.iceb.beans.Comment;
import dev.iceb.data.CommentDAO;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
	@Mock
	static CommentDAO cDao;
	
	@InjectMocks
	static CommentServiceImpl cServ;
	
	static Set<Comment> commentMock = new HashSet<>();
	static Integer sequenceMock = 1;
	
	@Test
	public void testAddComment() {
		Comment p = new Comment();
		p.setId(1);
		commentMock.add(p);
		
		Comment p2 = new Comment();
		p2.setId(sequenceMock +=1);
		
		when(cDao.add(p)).thenReturn(p2);
		assertNotEquals(p.getId().intValue(), cServ.addComment(p).getId().intValue());
		verify(cDao).add(p);
	}
	
	@Test
	public void testGetCommentById() {
		Comment p = new Comment();
		p.setId(35);
		commentMock.add(p);
		
		when(cDao.getById(35)).thenReturn(p);
		assertEquals(p, cServ.getCommentById(35));
		verify(cDao).getById(35);
	}
	
	@Test
	public void testGetCommentsByPost() {
		Comment c = new Comment();
		Comment c1 = new Comment();
		Comment c2 = new Comment();
		c.setPost_id(1);
		c1.setPost_id(1);
		c2.setPost_id(2);
		commentMock.add(c);
		commentMock.add(c1);
		when(cDao.getByPostId(1)).thenReturn(commentMock);
		assertEquals(commentMock, cServ.getByPostId(1));
		assertNotEquals(commentMock, cServ.getByPostId(2));
		verify(cDao).getByPostId(1);
		verify(cDao).getByPostId(2);
	}
	
	@Test
	public void testUpdateComment() {
		Comment p = new Comment();
		cServ.updateComment(p);
		verify(cDao).update(p);
	}
}
