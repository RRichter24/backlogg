package dev.iceb.data;

import dev.iceb.beans.Post;

public interface PostDAO extends GenericDAO<Post>{
	public Post getByUserId(Integer id);
	public Post getByUsername(String u);
}
