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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.iceb.beans.Message;
import dev.iceb.services.MessageService;
import dev.iceb.services.PersonService;
import dev.iceb.services.PostService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@RequestMapping(path="/message")
public class MessageController {
	private MessageService messageServ;
	private PersonService perServ;
	
	@Autowired
	public MessageController(MessageService c, PersonService p) {
		messageServ = c;
		perServ = p;
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Message> getMessageById(
			HttpSession session, @PathVariable("id") Integer id){
		Message m = messageServ.getMessageById(id);
		
		if (m != null) {
			return ResponseEntity.ok(m);
		}//end if
		
		return ResponseEntity.notFound().build();
	}//end getMessageById
	
	@GetMapping(path = "/user/{id}")
	public ResponseEntity<Set<Message>> getMessagesByUserId(
			HttpSession session, @PathVariable("id") Integer id){
		Set<Message> personMessages = messageServ.getMessagesByUserId(id);
		if(personMessages != null) {
			return ResponseEntity.ok(personMessages);
		}else {//end if
			return ResponseEntity.notFound().build();
		}//end else
	}//end getMessagesByUserId
	
	
	@PostMapping
	public ResponseEntity<Message> addMessage(
			HttpSession session, @RequestBody Message message){
		Message m = messageServ.addMessage(message);
		
		if (m != null) {
			return ResponseEntity.ok(m);
		}//end if
		
		return ResponseEntity.badRequest().build();
	}//end add
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Void> updateMessage(
			HttpSession session, @RequestBody Message message){
		messageServ.updateMessage(message);
		return ResponseEntity.ok().build();
	}//end update
}//end class
