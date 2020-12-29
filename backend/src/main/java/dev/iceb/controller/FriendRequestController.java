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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.iceb.beans.FriendRequest;
import dev.iceb.beans.Message;
import dev.iceb.services.FriendRequestService;
import dev.iceb.services.RequestStatusService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(path="/friend")
public class FriendRequestController {
	
	private FriendRequestService frServ;
	private RequestStatusService rsServ;
	
	@Autowired
	public FriendRequestController(FriendRequestService fr, RequestStatusService rs) {
		frServ = fr;
		rsServ = rs;
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<FriendRequest> getFriendRequestById(
			HttpSession session, @PathVariable("id") Integer id){
		FriendRequest request = frServ.getFriendRequestById(id);
		
		if(request != null) {
			return ResponseEntity.ok(request);
		}//end if
		return ResponseEntity.notFound().build(); 
	}//end get by id

	
	@PostMapping
	public ResponseEntity<FriendRequest> addFriendRequest(
			HttpSession session, @RequestBody FriendRequest FriendRequest){
	FriendRequest m = frServ.addFriendRequest(FriendRequest);
		
		if (m != null) {
			return ResponseEntity.ok(m);
		}//end if
		
		return ResponseEntity.badRequest().build();
	}//end add
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> updateFriendRequest(
			HttpSession session, @RequestBody FriendRequest friendRequest){
		frServ.updateFriendRequest(friendRequest);
		return ResponseEntity.ok().build();
	}//end update
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteFriendRequest(
			HttpSession session, @RequestBody FriendRequest friendRequest){
		frServ.deleteFriendRequest(friendRequest);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = "/sent/{id}")
	public ResponseEntity<Set<FriendRequest>> getSentFriendRequests(
			HttpSession session, @PathVariable("id") Integer id){
		Set<FriendRequest> sentRequests = frServ.getSentFriendRequests(id);
		if(sentRequests != null) {
			return ResponseEntity.ok(sentRequests);
		}//end if
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/received/{id}")
	public ResponseEntity<Set<FriendRequest>> getReceivedFriendRequests(
			HttpSession session, @PathVariable("id") Integer id){
		Set<FriendRequest> recRequests = frServ.getReceivedFriendRequests(id);
		if(recRequests != null) {
			return ResponseEntity.ok(recRequests);
		}//end if
		return ResponseEntity.notFound().build();
	}
}
