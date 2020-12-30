import { Component, Input, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';
import { PostService } from 'src/app/services/post.service';
import { RecentDateService } from 'src/app/services/recent-date.service';
import { SignoutService } from 'src/app/services/signout.service';

import Person from 'src/app/models/person';
import Post from 'src/app/models/post';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  loggedInUser: Person
  posts: Set<Post>
  adminPosts: Set<Post>
  adminList: Boolean = false;

  constructor(private personService: PersonService, 
    private postService: PostService, 
    private recentDateService: RecentDateService,
    private signoutService: SignoutService) { }


  ngOnInit(): void {
    this.loggedInUser = JSON.parse(sessionStorage.getItem('loggedInUser'));
    console.log('in [ProfileComponent]');
    console.log(this.loggedInUser);

    this.postService
      .retrieveUsersPosts(this.loggedInUser.id)
      .subscribe((resp) => {
        this.posts = this.recentDateService.sortDatesByMostRecentToLeastRecent(resp);
        for (let post of this.posts) {
          console.log(post);
        }
});

    if (this.loggedInUser.role.name == "admin") {
      this.postService.retrieveAllPosts().subscribe(resp => {
      this.adminPosts = resp;
      });
    }
  }

  showAdminList() {
    this.adminList = true;
  }

  hideAdminList() {
    this.adminList = false;
  }

  logout(){
    this.signoutService.logout();
  }
}
