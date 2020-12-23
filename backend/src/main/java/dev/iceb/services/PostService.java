package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Comment;
import dev.iceb.beans.Post;

public interface PostService {
		// "create" method: returns the unique identifier of the added Cat
		public Post addPost(Post p);
		// "read" methods
		public Post getPostById(Integer id);
		public Set<Comment> getCommentsByPostId(Integer id);
		public Set<Post> getPostsByUserId(Integer id);
		public Set<Post> getPostsByUsername(String u);
		public Set<Post> getPosts();
		// "update" methods
		public void updatePost(Post p);
		// "delete" methods
		public void removePost(Post p);
}
