import { Component, OnInit } from '@angular/core';
import { FriendRequest } from 'src/app/models/friend-request';
import Person from 'src/app/models/person';
import { FriendRequestService } from 'src/app/services/friend-request.service';
import { PersonService } from 'src/app/services/person.service';
import { SignoutService } from 'src/app/services/signout.service';

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
  
  // Set<{  //   tried to build my own set for science so that I could get usernames but I havent worked it out yet
  //   id: number;
  //   sender: Person;
  //   recipient: Person;
  //   status: string;
  // }>;
  recipient_id: number;

  friendRequest: number;
  constructor(private personService: PersonService, 
    private friendRequestService: FriendRequestService,
    private signoutService: SignoutService) { }

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
    document.location.reload();
  }

  acceptRequest(id:number){
    this.friendRequestService.acceptFriendRequest(id).subscribe();
    document.location.reload();
  }

  rejectRequest(id:number){
    this.friendRequestService.rejectFriendRequest(id).subscribe();
    document.location.reload();
  }

  getSentRequests(){
    this.friendRequestService.getSentRequestsByPersonId(this.loggedInUser.id).subscribe();
    document.location.reload();
  }

  getPersonByUsername(){
    this.personService.getPersonByUsername(this.username).subscribe(
      resp=>{
        this.searchedPerson = resp;
      });
  }

  logout(){
    this.signoutService.logout();
  }
  
}
