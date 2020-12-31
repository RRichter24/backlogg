import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import Person from 'src/app/models/person';
import Post from 'src/app/models/post';
import { PersonService } from 'src/app/services/person.service';
import { PostService } from 'src/app/services/post.service';
import { RecentDateService } from 'src/app/services/recent-date.service';

@Component({
  selector: 'app-others-profile',
  templateUrl: './others-profile.component.html',
  styleUrls: ['./others-profile.component.css']
})
export class OthersProfileComponent implements OnInit {

  wantedUser: Person;
  posts: Set<Post>;

  constructor(private route: ActivatedRoute, 
    private personService: PersonService, 
    private postService: PostService, 
    private recentDateService: RecentDateService) { 
      
    }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log('The user id of this route is: ', params.profilenum);

      this.personService.getPersonById(params.profilenum).subscribe(resp =>{
        console.log(resp);

        this.wantedUser = resp;
      });

      this.postService.retrieveUsersPosts(params.profilenum).subscribe(resp =>{
        console.log(resp);

        this.posts = this.recentDateService.sortPostDatesByMostRecentToLeastRecent(resp);
      })
    });


  }

}
