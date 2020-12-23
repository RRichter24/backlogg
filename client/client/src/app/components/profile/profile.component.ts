import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  loggedUser: Person;
  constructor() { }

  ngOnInit(): void {
    this.personService.loginUser(null,null).subscribe(
      resp => {
        this.loggedUser = resp;
      }
    );

  }

}
