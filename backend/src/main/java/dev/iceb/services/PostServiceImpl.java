package dev.iceb.services;

import java.util.Set;


import dev.iceb.beans.Post;
import dev.iceb.data.PostDAO;
import dev.iceb.data.PostDAOFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	private PostDAO postDao;
	
	@Autowired
	public PostServiceImpl(PostDAO pDAO) {
		postDao = pDAO;
	}
	
	public Post addPost(Post p) {
		return postDao.add(p);
	}

	public Post getPostById(Integer id) {
		return postDao.getById(id);
	}

	public Set<Post> getPostsByUserId(Integer id) {
		return postDao.getByUserId(id);
	}

	public Set<Post> getPostsByUsername(String u) {
		return postDao.getByUsername(u);
	}

	public Set<Post> getPosts() {
		return postDao.getAll();
	}

	public void updatePost(Post p) {
		postDao.update(p);
	}

	public void removePost(Post p) {
		postDao.delete(p);
	}

}
