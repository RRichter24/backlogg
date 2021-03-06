package dev.iceb.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.iceb.beans.Person;
import dev.iceb.beans.Post;
import dev.iceb.services.PersonService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@RequestMapping(path="/users")
public class PersonController {
	private PersonService personServ;
	
	@Autowired
	public PersonController(PersonService p) {
		personServ = p;
	}
	
	@GetMapping
	public ResponseEntity<Person> checkLogin(HttpSession session){
		Person supposedLoggedInPerson = (Person) session.getAttribute("user");
		if (supposedLoggedInPerson == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(supposedLoggedInPerson);
	}
	
	@PutMapping
	public ResponseEntity<Person> logIn(HttpSession session, @RequestParam("user") String username, @RequestParam("pass") String password){
		System.out.println("hitting the login endpoint");
		Person person = personServ.getByUsername(username);
		if (person != null) {
			if (person.getPasswd().equals(password)) {
				return ResponseEntity.ok(person);
			}
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Person> registerPerson(HttpSession session, @RequestBody Person person) {
		System.out.println("The Deadly Six: Zazz, Zomom, Zavik, Zor, etc, etc");
		personServ.add(person);
		return ResponseEntity.ok(person);
	}
	
	
	@DeleteMapping
	public ResponseEntity<Void> logOut(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}
	

	@PutMapping(path="/{id}")
	public ResponseEntity<Void> updatePerson(HttpSession session, @PathVariable("id") Integer id, @RequestBody Person person){
		Person loggedPerson = (Person) session.getAttribute("user");
		System.out.println("PERSON CONTROLLER" + person);
		if (loggedPerson != null && loggedPerson.getId().equals(id)) {
			personServ.update(person);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Person> getUserById(HttpSession session, @PathVariable("id") Integer id){
		Person p = personServ.getById(id);
		if(p != null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.notFound().build();
	}
	//path extended with username to avoid ambiguous call
	@GetMapping(path = "username/{username}")
	public ResponseEntity<Person> getUserByUsername(HttpSession session, @PathVariable("username") String username){
		Person p = personServ.getByUsername(username);
		if(p != null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<Set<Person>> getAllPersons(HttpSession session){
		Set<Person> allPersons = personServ.getAll();
		return ResponseEntity.ok(allPersons);
	}
	
}
