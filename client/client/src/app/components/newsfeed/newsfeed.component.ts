import { Component, OnInit } from '@angular/core';
import { SignoutService } from 'src/app/services/signout.service';

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css']
})
export class NewsfeedComponent implements OnInit {

  constructor(private signoutService: SignoutService) { }

  ngOnInit(): void {
  }

  logout(){
    this.signoutService.logout();
  }

}
