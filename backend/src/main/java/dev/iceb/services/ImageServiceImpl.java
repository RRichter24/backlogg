package dev.iceb.services;

import org.springframework.beans.factory.annotation.Autowired;

import dev.iceb.beans.Image;
import dev.iceb.data.ImageDAO;

public class ImageServiceImpl implements ImageService {
	
	private ImageDAO imageDAO;
	
	@Autowired
	public ImageServiceImpl(ImageDAO imgDAO) {
		imageDAO = imgDAO;
	}
	
	
	@Override
	public Image add(Image p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getByPostId(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image update(Image p) {
		// TODO Auto-generated method stub
		return null;
	}

}
