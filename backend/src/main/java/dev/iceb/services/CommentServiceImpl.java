package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Comment;
<<<<<<< HEAD
import dev.iceb.beans.Post;
import dev.iceb.data.CommentDAO;
import dev.iceb.data.CommentDAOFactory;
import dev.iceb.data.PostDAO;
import dev.iceb.data.PostDAOFactory;

public class CommentServiceImpl implements CommentService {
	
	private CommentDAO commentDAO;
	
	public CommentServiceImpl() {
		CommentDAOFactory commentDAOFactory = new CommentDAOFactory();
		commentDAO = commentDAOFactory.getCommentDAO();
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
		
=======
import dev.iceb.data.CommentDAO;
import dev.iceb.data.CommentDAOFactory;

public class CommentServiceImpl implements CommentService {
private CommentDAO CommentDao;
	
	public CommentServiceImpl() {
		CommentDAOFactory rdf = new CommentDAOFactory();
		CommentDao = rdf.getCommentDAO();
	}
	@Override
	public Comment addComment(Comment p) {
		return CommentDao.add(p);
	}

	@Override
	public Comment getCommentById(Integer id) {
		return CommentDao.getById(id);
	}

	@Override
	public Set<Comment> getComments() {
		return CommentDao.getAll();
	}

	@Override
	public void updateComment(Comment p) {
		CommentDao.update(p);
	}

	@Override
	public void removeComment(Comment p) {
		CommentDao.delete(p);
>>>>>>> fd101b8b12ffd27753be6c7afe04463862ca87c5
	}

}
