import { Component, OnInit } from '@angular/core';
import { UserService } from './services/user.service';

@Component({
  selector: 'register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  username: String = '';
  password: String = '';

  constructor(private userService: UserService) { 
    this.username = '';
    this.password = '';
  }

  ngOnInit(): void {

  }

  ngOnChange(): void {
    console.log(this.username + " and " + this.password);
  }

  register(){
    console.log(this.username + " and "+ this.password);
    //this.userService.registerAUser(this.username, this.password);
  }
}

