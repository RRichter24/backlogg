import { Component, Input, OnInit } from '@angular/core';
import Person from 'src/app/models/person';
import { PersonService } from 'src/app/services/person.service';
import Post from 'src/app/models/post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  loggedInUser: Person;
  posts: Set<Post>;

  constructor(
    private personService: PersonService,
    private postService: PostService
  ) {}

  ngOnInit(): void {
    this.loggedInUser = JSON.parse(sessionStorage.getItem('loggedInUser'));
    console.log('in [ProfileComponent]');
    console.log(this.loggedInUser);

    this.postService
      .retrieveUsersPosts(this.loggedInUser.id)
      .subscribe((resp) => {
        this.posts = resp;
        for (let post of this.posts) {
          console.log(post);
        }
      });
  }
}
