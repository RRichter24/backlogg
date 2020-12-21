package dev.iceb.services;

import java.util.Set;

import dev.iceb.beans.Comment;
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
	}

}
