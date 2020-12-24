import { Component, OnInit } from '@angular/core';
import Person from 'src/app/models/person';
import { PersonService } from 'src/app/services/person.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.css']
})
export class NewPostComponent implements OnInit {
  personService: PersonService;
  postService: PostService;
  loggedUser: Person;
  text: String;

  constructor() { }

  ngOnInit(): void {
    this.loggedUser = this.personService.getLoggedUser();
    this.text = '';
  }

  submitPost() {
    this.postService.submitNewPost(this.text, this.loggedUser.id);
  }

}
