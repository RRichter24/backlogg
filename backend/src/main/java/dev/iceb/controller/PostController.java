package dev.iceb.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.iceb.beans.Comment;
import dev.iceb.beans.Message;
import dev.iceb.beans.Person;
import dev.iceb.beans.Post;
import dev.iceb.services.PostService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
public class PostController {

	private PostService postServ;
	
	@Autowired
	public PostController(PostService p) {
		postServ = p;
	}
	
	@GetMapping(path="/post/{postId}/comments/")
	public ResponseEntity<Set<Comment>> getCommentsByPostId(HttpSession session, @PathVariable("postId") Integer postId){
		Set<Comment> commentsOfPost = postServ.getCommentsByPostId(postId);
		if(commentsOfPost != null) {
			return ResponseEntity.ok(commentsOfPost);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path="/post/{id}")
	public ResponseEntity<Post> getPostById(HttpSession session, @PathVariable("id") Integer id, @RequestBody Post post){
		Post searchedPost = postServ.getPostById(id);
		
		if (searchedPost != null) {
			return ResponseEntity.ok(post);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(path="/post")
	public ResponseEntity<Post> addPost(HttpSession session, @RequestBody Post post){
		Post p = postServ.addPost(post);
		System.out.println(post.getPerson_id());
		System.out.println(post.getPost_text());
		
		if (p != null) {
			return ResponseEntity.ok(p);
		}//end if
		
		return ResponseEntity.badRequest().build();
	}
	
//	@PutMapping(path="/post")
//	public ResponseEntity<Void> updatePost(HttpSession session, @RequestBody Post post){
//		Post loggedPost = (Post) session.getAttribute("user");
//		if (loggedPost != null && loggedPost.getId().equals(id)) {
//			postServ.updatePost(post);
//			return ResponseEntity.ok().build();
//		}
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//	}
	
	
}
