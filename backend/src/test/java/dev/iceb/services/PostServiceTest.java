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
import dev.iceb.beans.Person;
import dev.iceb.beans.Post;
import dev.iceb.data.PersonDAO;
import dev.iceb.data.PostDAO;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
	@Mock
	static PostDAO pDao;
	
	@Mock
	static PersonDAO personDao;
	
	@InjectMocks
	static PostServiceImpl postServ;
	
	@InjectMocks
	static PersonServiceImpl personServ;
	
	static Set<Post> postMock = new HashSet<>();
	static Set<Comment> commentMock = new HashSet<>();
	static Integer sequenceMock =1;
	
	@Test
	public void testAddPost() {
		Post p = new Post();
		p.setId(1);
		postMock.add(p);
		
		Post p2 = new Post();
		p2.setId(sequenceMock +=1);
		
		when(pDao.add(p)).thenReturn(p2);
		assertNotEquals(p.getId().intValue(), postServ.addPost(p).getId().intValue());
		verify(pDao).add(p);
	}
	
	@Test
	public void testUpdatePost() {
		Post p = new Post();
		postServ.updatePost(p);
		verify(pDao).update(p);
	}
	
	@Test
	public void testGetPosts() {
		when(pDao.getAll()).thenReturn(postMock);
		assertEquals(postMock, postServ.getPosts());
		verify(pDao).getAll();
	}
	/*This commented out test belongs in CommentTest*/
//	@Test
//	public void testGetCommentsByPostId() {
//		Post p = new Post();
//		p.setId(1);
//		Post p2 = new Post();
//		p2.setId(2);
//		Comment c1 = new Comment();
//		Comment c2 = new Comment();
//		Comment c3 = new Comment();
//		c1.setPost_id(p.getId());
//		c2.setPost_id(p.getId());
//		c3.setPost_id(p2.getId());
//		commentMock.add(c1);
//		commentMock.add(c2);
//		
//		when(postServ.getCommentsByPostId(1)).thenReturn(commentMock);
//		assertEquals(postMock, postServ.getCommentsByPostId(1));
//		verify(pDao).get
//	}
	
	@Test
	public void testGetPostById() {
		Post p = new Post();
		p.setId(55);
		postMock.add(p);
		
		when(pDao.getById(55)).thenReturn(p);
		assertEquals(p, postServ.getPostById(55));
		verify(pDao).getById(55);
		postMock.remove(p);
	}
	
	@Test
	public void testRetrieveUsersPosts() {
		Person p = new Person();
		p.setId(1);
		Post post = new Post();
		post.setPerson_id(1);
		postMock.add(post);
		when(pDao.getByUserId(1)).thenReturn(postMock);
		assertEquals(postMock, postServ.getPostsByUserId(1));
		verify(pDao).getByUserId(1);
	}
	
}
