import { Component, OnInit } from '@angular/core';
import Message from 'src/app/models/message';
import Person from 'src/app/models/person';
import { MessageService } from 'src/app/services/message.service';
import { PersonService } from 'src/app/services/person.service';
import { SignoutService } from 'src/app/services/signout.service';

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
  reply = false;
  verify = false;
  aName: string;

  constructor(private personService: PersonService, 
    private messageService: MessageService, 
    private signoutService: SignoutService) { }

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
    this.personService.getPersonByUsername(this.username).subscribe(
      resp =>{
          this.receiver = resp;
          if(this.receiver.id <=0){
            console.log("that user doesn't exist");
            document.location.reload();
          }else{
            this.verify = true;
          }
      }
    );
  }

  // getPersonById(id: number){
  //   this.personService.getPersonById(id).subscribe(
  //     resp =>{
  //       this.aName = resp.username
  //     });
      
  // }

  sendMessage(){
    this.messageService.createNewMessage(this.text, this.loggedInUser.id, this.receiver.id).subscribe();
    this.text = '';
    this.username = '';
    document.location.reload();
  }

  replyMessage(id:number){
    console.log(id);
    // this.messageService.createNewMessage(this.text, this.loggedInUser.id, id).subscribe();
    // this.text = '';
    // this.username = '';
    // document.location.reload();
  }

  displayReply(){
    this.reply = true;
  }

  logout(){
    this.signoutService.logout();
  }

}
