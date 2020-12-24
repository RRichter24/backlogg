import { Component, OnInit } from '@angular/core';
import { SignUpService } from '../../services/signup.service';
import Person from '../../models/person';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  username: string;
  password: string;
  passwordCheck: string;
  company: string;
  email: string;

  constructor(private signUpService: SignUpService) { 
    this.username = '';
    this.password = '';
    this.passwordCheck = '';
    this.company = '';
    this.email = '';
  }

  ngOnInit(): void {

  }

  ngOnChange(): void {
    console.log(this.username + " and " + this.password);
  }

  register(){
    console.log(this.username + " and "+ this.password + " work at " + this.company + " with e-mail " + this.email);

    let newPerson: Person = {
      id: 0,
      username: this.username,
      email: this.email,
      company: this.company,
      passwd: this.password,
      role: {
        id: 1,
        name: "user"
      }
    }

    if (this.password === this.passwordCheck){
      this.signUpService.registerAUser(newPerson).subscribe(resp => {
        console.log(resp);
      });
    }
  }
}

