package dev.iceb.services;

import dev.iceb.beans.Image;

public interface ImageService {
	
	public Image add(Image p); 
	public Image getById(Integer id); 
	public Image getByPostId(Integer pid);
	public Image update(Image p);
}
