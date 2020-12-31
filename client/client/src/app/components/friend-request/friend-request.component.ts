import { Component, OnInit } from '@angular/core';
import { FriendRequest } from 'src/app/models/friend-request';
import Person from 'src/app/models/person';
import { FriendRequestService } from 'src/app/services/friend-request.service';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-friend-request',
  templateUrl: './friend-request.component.html',
  styleUrls: ['./friend-request.component.css']
})
export class FriendRequestComponent implements OnInit {
  loggedInUser: Person;
  userFriendRequests: Set<FriendRequest>;
  username: string;
  searchedPerson: Person;
  friendsList: Set<Person>;
  pendingRequests: Set<FriendRequest>;
  sentRequests: Set<FriendRequest>;
  recipient_id: number;

  friendRequest: number;
  constructor(private personService: PersonService, 
    private friendRequestService: FriendRequestService) { }

//TODO get pendingRequests to display
  ngOnInit(): void {
    this.loggedInUser = JSON.parse( sessionStorage.getItem("loggedInUser") );
    
    this.friendRequestService.getReceivedRequestsByPersonId(this.loggedInUser.id).subscribe(
      resp=> {this.pendingRequests = resp; }//end resp
    );//end subscribe
    
    this.friendRequestService.getSentRequestsByPersonId(this.loggedInUser.id).subscribe(
      resp => {
        this.sentRequests = resp;
      }
    );

    this.friendRequestService.getPersonFriendList(this.loggedInUser.id).subscribe(
      resp=>{
        this.friendsList = resp;
      }
    );
  }//end ngOnInit

  getSenderUsername(id: number){
    this.personService.getPersonById(id).subscribe();
  }

  sendRequest(){
    this.friendRequestService.sendFriendRequest(this.loggedInUser.id, this.searchedPerson.id).subscribe();
    window.location.reload();
  }

  acceptRequest(id:number){
    this.friendRequestService.acceptFriendRequest(id).subscribe();
    window.location.reload();
  }

  rejectRequest(id:number){
    this.friendRequestService.rejectFriendRequest(id).subscribe();
    window.location.reload();
  }

  getSentRequests(){
    this.friendRequestService.getSentRequestsByPersonId(this.loggedInUser.id).subscribe();
    window.location.reload();
  }

  getPersonByUsername(){
    this.personService.getPersonByUsername(this.username).subscribe(
      resp=>{
        this.searchedPerson = resp;
      });
  }

  logout(){
    this.personService.logoutUser();
  }
  
}
