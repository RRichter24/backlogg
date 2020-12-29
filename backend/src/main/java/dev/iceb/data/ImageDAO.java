package dev.iceb.data;

import dev.iceb.beans.Image;

public interface ImageDAO extends GenericDAO<Image>{
	public Image getByPostId(Integer pid); 
}
