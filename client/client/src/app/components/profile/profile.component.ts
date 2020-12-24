import { Component, Input, OnInit } from '@angular/core';
import  Person  from 'src/app/models/person';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  loggedInUser: Person; 
  constructor(private personService: PersonService) { }

  ngOnInit(): void { 

    this.loggedInUser = JSON.parse( sessionStorage.getItem("loggedInUser") ); 
    console.log("in [ProfileComponent]");
    console.log(this.loggedInUser);

  }

}
