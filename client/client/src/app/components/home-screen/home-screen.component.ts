import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.css']
})
export class HomeScreenComponent implements OnInit {

  username!: String;
  password!: String;

  constructor() { }

  ngOnInit(): void {
    this.username = '';
    this.password = '';
  }

  register(){
    console.log(this.username + " and "+ this.password);
    
  }
}
