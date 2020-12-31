package dev.iceb.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.iceb.beans.Reaction;
import dev.iceb.services.ReactionService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
public class ReactionController {

	private ReactionService reactionServ;
	
	@Autowired
	public ReactionController(ReactionService p) {
		reactionServ = p;
	}
	
	@PostMapping(path="/reaction")
	public ResponseEntity<Reaction> addReaction(HttpSession session, @RequestBody Reaction reaction){
		Reaction rxn = reactionServ.addReaction(reaction);
		System.out.println(reaction.toString());
		
		if (rxn != null) {
			return ResponseEntity.ok(rxn);
		}//end if
		
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping(path="/reaction/postid/{postid}")
	public ResponseEntity<Set<Reaction>> getReactionsByPostId(@PathVariable("postid") Integer pid){
		
		try {
			Set<Reaction> reactions = reactionServ.getByPostId(pid); 
			return ResponseEntity.ok(reactions); 
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.badRequest().build(); 
		}
	}
	
	@DeleteMapping(path="/reaction/reactionid/{rid}")
	public ResponseEntity<Object> deleteReaction(@PathVariable("rid") Integer rid){
		
		try {
			reactionServ.removeReaction( reactionServ.getReactionById(rid) );
			return ResponseEntity.ok().build(); 
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.badRequest().build(); 
		}
	}
}
