import { Component, OnInit } from '@angular/core';
import Message from 'src/app/models/message';
import Person from 'src/app/models/person';
import { MessageService } from 'src/app/services/message.service';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  loggedInUser: Person;
  text: string;
  receiver: Person;
  username: string;
  recid: number;
  userMessages: Set<Message>;

  constructor(private personService: PersonService, private messageService: MessageService) { }

  ngOnInit(): void {
    this.loggedInUser = JSON.parse( sessionStorage.getItem("loggedInUser") );
    this.text = '';
    this.username = '';
    this.messageService.messagesByPersonId(this.loggedInUser.id).subscribe(
      resp=> {
        this.userMessages = resp;
      }
    );
  }

  getReceiverByUsername(){
    this.personService.getPersonByUsername(this.username).subscribe();
  }

  sendMessage(){
    this.messageService.createNewMessage(this.text, this.loggedInUser.id, this.recid).subscribe();
  }

}
