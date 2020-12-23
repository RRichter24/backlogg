package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Comment;
import dev.iceb.beans.Post;

public interface CommentService {
	//create methods
	public Comment addComment(Comment c);
	
	//read methods
	public Comment getCommentById(Integer id);
	public Post getPostCommentCameFrom(Integer id);
	public Set<Comment> getCommentsByUserId(Integer userId);
	public Set<Comment> getCommentsByUsername(String username);
	public Set<Comment> getAllComments();
	
	//update methods
	public void updateComment(Comment c);
	
	//delete methods
	public void deleteComment(Comment c);
	
}
