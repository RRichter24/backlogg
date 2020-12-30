import { Component, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';
import Person from 'src/app/models/person';
import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {

  wantedUsername: string;

  isUserLoggedIn: boolean;
  constructor(
    private sessionStorageWrapperService: SessionStorageWrapperService,
    private personService: PersonService
  ) {
    this.wantedUsername = '';
  }

  ngOnInit(): void {
    this.sessionStorageWrapperService.changeEmitted$.subscribe((person) => {
      if (person) {
        this.isUserLoggedIn = true;
      } else {
        this.isUserLoggedIn = false;
      }
    });
  }

  lookUpPerson(): void{
    this.personService.getPersonByUsername(this.wantedUsername).subscribe(resp => {
      console.log(resp);
      let retrievedPerson: Person = resp;

      alert("I have retrieved the person with the username " + retrievedPerson.username);
    });
  }

  logout() {
    this.sessionStorageWrapperService.setLoggedUser(null);
  }
}
