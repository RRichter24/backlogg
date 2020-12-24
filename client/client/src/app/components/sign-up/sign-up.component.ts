import { Component, OnInit } from '@angular/core';
import { SignUpService } from '../../services/signup.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  newlyRegisteredUsername: String;
  newlyRegisteredPassword: String;
  passwordCheck: String;

  constructor(private signUpService: SignUpService) { 
    this.newlyRegisteredUsername = '';
    this.newlyRegisteredPassword = '';
    this.passwordCheck = '';
  }

  ngOnInit(): void {

  }

  ngOnChange(): void {
    console.log(this.newlyRegisteredUsername + " and " + this.newlyRegisteredPassword);
  }

  register(){
    console.log(this.newlyRegisteredUsername + " and "+ this.newlyRegisteredPassword);

    if (this.newlyRegisteredPassword === this.passwordCheck){
      this.signUpService.registerAUser(this.newlyRegisteredUsername, this.newlyRegisteredPassword);
    }
  }
}

