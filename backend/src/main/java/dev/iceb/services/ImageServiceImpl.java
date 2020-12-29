package dev.iceb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.iceb.beans.Image;
import dev.iceb.data.ImageDAO;
@Service
public class ImageServiceImpl implements ImageService {
	
	private ImageDAO imageDAO;
	
	@Autowired
	public ImageServiceImpl(ImageDAO imgDAO) {
		imageDAO = imgDAO;
	}
	
	
	@Override
	public Image add(Image p) {
		return imageDAO.add(p); 
	}

	@Override
	public Image getById(Integer id) {
		return imageDAO.getById(id);
	}

	@Override
	public Image getByPostId(Integer pid) {
		return imageDAO.getByPostId(pid);
	}

	@Override
	public void update(Image p) {
		imageDAO.update(p);
	}

}
