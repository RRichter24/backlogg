import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Person from 'src/app/models/person';
import Post from 'src/app/models/post';
import { FriendRequestService } from 'src/app/services/friend-request.service';
import { PersonService } from 'src/app/services/person.service';
import { PostService } from 'src/app/services/post.service';
import { RecentDateService } from 'src/app/services/recent-date.service';
import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';
import { SignoutService } from 'src/app/services/signout.service';

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css',]
})
export class NewsfeedComponent implements OnInit {
  
  loggedInUser: Person;
  posts: Set<Post>;
  friendsList: Set<Person>;
  friendsPosts: Set<Post>;
  allPosts: Set<Post>;

  constructor(
    private personService: PersonService,
    private postService: PostService,
    private recentDateService: RecentDateService,
    private friendRequestService: FriendRequestService,
    private sessionStorageWrapperService: SessionStorageWrapperService,
    private router: Router) { }

  ngOnInit(): void {
    this.loggedInUser = this.sessionStorageWrapperService.getLoggedUser();
    
    this.postService
    .retrieveUsersPosts(this.loggedInUser.id)
    .subscribe((resp) => {
      this.posts = this.recentDateService.sortPostDatesByMostRecentToLeastRecent(resp);
      for (let post of this.posts) {
        console.log(post);
      }
    });

    this.friendRequestService.getPersonFriendList(this.loggedInUser.id).subscribe(
      resp=>{
        this.friendsList = resp;
          for(let friend of this.friendsList){
            this.postService
            .retrieveUsersPosts(friend.id)
            .subscribe((resp2) => {
                this.friendsPosts = this.recentDateService.sortPostDatesByMostRecentToLeastRecent(resp2);
                });//sub 
              }//for
          });//outersub

    this.sessionStorageWrapperService.changeEmitted$.subscribe((person) => {
      if (!person) {
        this.router.navigate(['/']);
      }
    });

  }//end onInit






}//end class
