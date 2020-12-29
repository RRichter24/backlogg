package dev.iceb.controller;


import dev.iceb.beans.Image;
import dev.iceb.beans.Post;
import dev.iceb.services.ImageService;
import dev.iceb.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:4200",  allowCredentials="true")
@RequestMapping(path="/images")
public class ImageController {
	private ImageService imgServ;
	
	@Autowired
	public ImageController(ImageService p) {
		imgServ = p;
	}

    @SuppressWarnings("unused")
	@PostMapping("/upload/postid/{postid}")
    public ResponseEntity<Image> uplaodImage(@RequestParam("myFile") MultipartFile file, @PathVariable("postid") Integer postId) throws IOException {

        Image img = new Image( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        img.setPostId(postId);
        System.out.println(img.toString());
        
        Image newImg = imgServ.add(img); 
        
        if (newImg != null) {
            System.out.println("Image saved");
        	return ResponseEntity.ok(newImg); 
        } else {
        	return ResponseEntity.badRequest().build(); 
        }
    }
    
	@GetMapping(path="/postid/{pid}")
	public ResponseEntity<Image> getImageByPostId(HttpSession session, @PathVariable("pid") Integer postId){
		Image img = imgServ.getByPostId(postId);
		
		if (img != null) {
			return ResponseEntity.ok(img);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
    
    
}