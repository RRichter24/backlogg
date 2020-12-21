package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Comment;

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
}
