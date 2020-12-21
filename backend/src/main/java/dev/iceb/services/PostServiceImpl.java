package dev.iceb.services;

import java.util.Set;


import dev.iceb.beans.Post;
import dev.iceb.data.PostDAO;
import dev.iceb.data.PostDAOFactory;

public class PostServiceImpl implements PostService {

	private PostDAO postDao;
	
	public PostServiceImpl() {
		PostDAOFactory postDaoFactory = new PostDAOFactory();
		postDao = postDaoFactory.getPostDAO();
	}
	
	public Post addPost(Post p) {
		return postDao.add(p);
	}

	public Post getPostById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Post> getPostsByUserId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Post> getPostsByUsername(String u) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Post> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePost(Post p) {
		// TODO Auto-generated method stub
		
	}

	public void removePost(Post p) {
		// TODO Auto-generated method stub
		
	}

}
