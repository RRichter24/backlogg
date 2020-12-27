package dev.iceb.controller;


import dev.iceb.beans.Image;
import dev.iceb.services.ImageService;
import dev.iceb.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/images")
public class ImageController {
	private ImageService imgServ;
	
	@Autowired
	public ImageController(ImageService p) {
		imgServ = p;
	}

    @PostMapping("/upload")
    public Image uplaodImage(@RequestParam("myFile") MultipartFile file, @RequestParam("postId") Integer postId) throws IOException {

        Image img = new Image( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        img.setPostId(postId);
        System.out.println(img.toString());


        System.out.println("Image saved");
        
        return img; 
    }
}