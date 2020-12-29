package dev.iceb.data;

import java.util.Set;

import dev.iceb.beans.Comment;

public interface CommentDAO extends GenericDAO<Comment> {

	Set<Comment> getByPostId(Integer pid);

}
