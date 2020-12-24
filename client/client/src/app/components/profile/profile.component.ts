import { Component, OnInit } from '@angular/core';
import  Person  from 'src/app/models/person';
<<<<<<< HEAD
=======
import { PersonService } from 'src/app/services/person.service';
>>>>>>> d2acbf93704b8bef49a4d0107e022aa26d19e6d3

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
<<<<<<< HEAD
  loggedUser: Person | undefined;
  constructor() { }

  ngOnInit(): void {
    // this.personService.loginUser(null,null).subscribe(
    //   resp => {
    //     this.loggedUser = resp;
    //   }
    // );
=======
  loggedUser: Person;
  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.personService.loginUser(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      }
    );
>>>>>>> d2acbf93704b8bef49a4d0107e022aa26d19e6d3

  }

}
