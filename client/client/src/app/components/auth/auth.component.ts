import { Component, OnInit } from '@angular/core';
import { browser } from 'protractor';
import { Observable } from 'rxjs/internal/Observable';
import Person from '../../models/person';
import { PersonService } from '../../services/person.service';
import { Router } from '@angular/router';
import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit {
  username: string = '';
  password: string = '';
  private isValidUsername: boolean = false;
  private isValidPassword: boolean = false;

  btnStyle: String = 'btn btn-lg btn-primary btn-block disabled';

  constructor(
    private personService: PersonService,
    private router: Router,
    private sessionStorageWrapperService: SessionStorageWrapperService
  ) {}

  validateInput() {
    console.log('validating...');
    let canSignIn: boolean = true;
    if (this.username.length === 0) {
      canSignIn = false;
    }

    if (this.password.length === 0) {
      canSignIn = false;
    }

    console.log(canSignIn);
    if (canSignIn) {
      console.log('here');
      this.btnStyle = 'btn btn-lg btn-primary btn-block';
    } else {
      this.btnStyle = 'btn btn-lg btn-primary btn-block disabled';
    }
  }

  onSignIn() {
    console.log(this.username, this.password);
    this.personService.loginUser(this.username, this.password).subscribe(
      (resp) => {
        console.log(resp);
        /**
         * The current user is stored in sessionStorage as a stringified JSON
         * object. This
         */
        let loggedInUser: Person = resp;
        this.sessionStorageWrapperService.setLoggedUser(loggedInUser);
        this.router.navigate(['/profile']);
      },
      (err) => {
        alert('Internal System Error. Unable to log in.\n' + err);
      }
    );
  }

  ngOnInit(): void {}
}
