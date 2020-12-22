package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Comment;
import dev.iceb.beans.Post;

import dev.iceb.data.CommentDAO;
import dev.iceb.data.CommentDAOFactory;
import dev.iceb.data.PostDAO;
import dev.iceb.data.PostDAOFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentDAO commentDAO;
	
	@Autowired
	public CommentServiceImpl(CommentDAO cDAO) {
		commentDAO = cDAO;
	}

	public Comment addComment(Comment c) {
		return commentDAO.add(c);
	}

	public Comment getCommentById(Integer id) {
		return commentDAO.getById(id);
	}

	public Post getPostCommentCameFrom(Integer id) {
		Comment comment = commentDAO.getById(id);
		PostDAO postDAO = new PostDAOFactory().getPostDAO();
		return postDAO.getById(comment.getPost_id());
	}

	public Set<Comment> getCommentsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Comment> getCommentsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Comment> getAllComments() {
		return commentDAO.getAll();
	}

	public void updateComment(Comment c) {
		commentDAO.update(c);
	}

	public void deleteComment(Comment c) {
		commentDAO.delete(c);
	}
}