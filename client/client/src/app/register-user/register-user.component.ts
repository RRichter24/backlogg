import { Component, OnInit } from '@angular/core';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.css']
})
export class RegisterUserComponent implements OnInit {

  username: String = '';
  password: String = '';

  constructor(private userService: UserService) { }

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

