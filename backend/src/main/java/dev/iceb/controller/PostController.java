package dev.iceb.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.iceb.beans.Comment;
import dev.iceb.services.PostService;

public class PostController {

	private PostService postServ;
	
	@Autowired
	public PostController(PostService p) {
		postServ = p;
	}
	
	@GetMapping(path="post/{postId}/comments/")
	public ResponseEntity<Set<Comment>> getCommentsByPostId(HttpSession session, @PathVariable("postId") Integer postId){
		Set<Comment> commentsOfAPost = postServ.getCommentsOfPost(postId);
		if(commentsOfAPost != null) {
			ResponseEntity.ok(commentsOfAPost);
		}
		
		ResponseEntity.notFound().build();
	}
	
	
	//i send in a comment id
	//i use the method getPostThatCommentCameFrom()
	//	to get that comment's corresponding post
	//i user
}
