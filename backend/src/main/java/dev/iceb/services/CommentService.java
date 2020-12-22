package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Comment;
<<<<<<< HEAD
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
	
=======

public interface CommentService {
	// "create" method: returns the unique identifier of the added Cat
	public Comment addComment(Comment p);
	// "read" methods
	public Comment getCommentById(Integer id);
	public Set<Comment> getComments();
	// "update" methods
	public void updateComment(Comment p);
	// "delete" methods
	public void removeComment(Comment p);
>>>>>>> fd101b8b12ffd27753be6c7afe04463862ca87c5
}
