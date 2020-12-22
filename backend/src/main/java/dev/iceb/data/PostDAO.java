package dev.iceb.data;

import java.util.Set;

import dev.iceb.beans.Post;

public interface PostDAO extends GenericDAO<Post>{
	public Set<Post> getByUserId(Integer id);
	public Set<Post> getByUsername(String u);
}
