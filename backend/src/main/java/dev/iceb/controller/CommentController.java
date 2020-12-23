package dev.iceb.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.iceb.beans.Comment;
import dev.iceb.services.CommentService;
import dev.iceb.services.PostService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
public class CommentController {
	private CommentService commentServ;
	private PostService postServ;
	
	@Autowired
	public CommentController(CommentService c, PostService p) {
		commentServ = c;
		postServ = p;
	}
	
	@GetMapping(path="comment/{id}")
	public ResponseEntity<Comment> getCommentById(HttpSession session, @PathVariable("id") Integer id){
		Comment wantedComment = commentServ.getCommentById(id);
		
		if (wantedComment != null) {
			return ResponseEntity.ok(wantedComment);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(path="comment")
	public ResponseEntity<Comment> addComment(HttpSession session, @RequestBody Comment comment){
		Comment returnedComment = commentServ.addComment(comment);
		
		if (returnedComment != null) {
			return ResponseEntity.ok(returnedComment);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping(path="comment/{id}")
	public ResponseEntity<Void> updateComment(HttpSession session, @RequestBody Comment comment){
		commentServ.updateComment(comment);
		return ResponseEntity.ok().build();
	}
}
