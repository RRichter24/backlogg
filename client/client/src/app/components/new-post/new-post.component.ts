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
  loggedInUser: Person;
  text: string;

  constructor(private personService: PersonService, private postService: PostService) { }

  ngOnInit(): void {
    this.loggedInUser = JSON.parse( sessionStorage.getItem("loggedInUser") );
    this.text = '';
  }

  submitPost() {
    console.log(this.text);
    console.log(this.loggedInUser.id);
    this.postService.submitNewPost(this.text, this.loggedInUser.id).subscribe(
      resp => {
        console.log(resp);
      });
  }

}
