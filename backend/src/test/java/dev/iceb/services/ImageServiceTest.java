package dev.iceb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.iceb.beans.Image;
import dev.iceb.beans.Image;
import dev.iceb.beans.Image;
import dev.iceb.data.ImageDAO;


@ExtendWith(MockitoExtension.class)
public class ImageServiceTest {
	
	@Mock
	static ImageDAO iDao;
	
	@InjectMocks
	static ImageServiceImpl iServ;
	
	static Set<Image> imageMock = new HashSet<>();
	static Integer sequenceMock = 1;
	
	@Test
	public void testUploadImage() {
		Image p = new Image();
		p.setId(1);
		imageMock.add(p);
		
		Image p2 = new Image();
		p2.setId(sequenceMock +=1);
		
		when(iDao.add(p)).thenReturn(p2);
		assertNotEquals(p.getId().intValue(), iServ.add(p).getId().intValue());
		verify(iDao).add(p);	
	}
	
	@Test
	public void testGetById() {
		Image p = new Image();
		p.setId(35);
		imageMock.add(p);
		
		when(iDao.getById(35)).thenReturn(p);
		assertEquals(p, iServ.getById(35));
		verify(iDao).getById(35);
	}
	
}
