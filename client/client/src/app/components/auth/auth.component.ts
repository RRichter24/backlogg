import { Component, OnInit} from '@angular/core';
import { browser } from 'protractor';
import { Person } from '../../models/person';
import { SiginService } from '../../services/sigin.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  username: String = '';
  password: String = '';
  private isValidUsername: boolean = false; 
  private isValidPassword: boolean = false; 

  btnStyle: String = "btn btn-lg btn-primary btn-block disabled"; 

  constructor() { }

  validateInput() {
    console.log("validating..."); 
    let canSignIn : boolean = true; 
    if ( this.username.length === 0 ) {
      canSignIn = false; 
    } 

    if ( this.password.length === 0 ) {
      canSignIn = false; 
    }

    console.log(canSignIn);
    if (canSignIn) {
      console.log('here');
      this.btnStyle = "btn btn-lg btn-primary btn-block";
    } else {
      this.btnStyle = "btn btn-lg btn-primary btn-block disabled";
    }
  }

  onSignIn() {
    console.log(this.username, this.password);
    // let person = Sigin.getPersonByUsername(); 

  }

  ngOnInit(): void {
  }

}
