package dev.iceb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
