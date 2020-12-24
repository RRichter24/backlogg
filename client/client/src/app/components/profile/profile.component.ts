import { Component, OnInit } from '@angular/core';
import  Person  from 'src/app/models/person';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  loggedUser: Person;
  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.personService.loginUser(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      }
    );

  }

}
