import { Component, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';

import Person from 'src/app/models/person';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  wantedUsername: string;

  constructor(private personService: PersonService) {
    this.wantedUsername = '';
  }

  ngOnInit(): void {
  }

  lookUpPerson(): void{
    this.personService.getPersonByUsername(this.wantedUsername).subscribe(resp => {
      console.log(resp);
      let retrievedPerson: Person = resp;

      alert("I have retrieved the person with the username " + retrievedPerson.username);
    });
  }

}
