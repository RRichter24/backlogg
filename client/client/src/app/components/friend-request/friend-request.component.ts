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
  
  pendingRequests: Set<FriendRequest>;
  
  // Set<{  //   tried to build my own set for science so that I could get usernames but I havent worked it out yet
  //   id: number;
  //   sender: Person;
  //   recipient: Person;
  //   status: string;
  // }>;
  recipient_id: number;

  friendRequest: number;
  constructor(private personService: PersonService, private frientRequestService: FriendRequestService) { }
//TODO get pendingRequests to display
  ngOnInit(): void {
    this.loggedInUser = JSON.parse( sessionStorage.getItem("loggedInUser") );
    this.frientRequestService.getReceivedRequestsByPersonId(this.loggedInUser.id).subscribe(
      resp=> {this.userFriendRequests = resp;
        for(let request of this.userFriendRequests){
          console.log(request);
          if(request.request_status.id == 1){
            this.pendingRequests.add(request
            
            
            //   {
            //   id: request.id,
            //   sender: this.personService.getPersonById(request.person1_id).subscribe(),
            //   recipient: "j",
            //   status: 'nah'
            // }
              );
          }
        }
      }
    );
  }

  getSenderUsername(id: number){
    this.personService.getPersonById(id).subscribe();
  }

  sendRequest(){
    this.frientRequestService.sendFriendRequest(this.loggedInUser.id, this.searchedPerson.id).subscribe();
  }

  acceptRequest(){
    this.frientRequestService.acceptFriendRequest(this.friendRequest).subscribe();
  }

  rejectRequest(){
    this.frientRequestService.rejectFriendRequest(this.friendRequest).subscribe();
  }

  getSentRequests(){
    this.frientRequestService.getSentRequestsByPersonId(this.loggedInUser.id).subscribe();
  }

  getPersonByUsername(){
    this.personService.getPersonByUsername(this.username).subscribe(
      resp=>{
        this.searchedPerson = resp;
      });
  }
  
}
