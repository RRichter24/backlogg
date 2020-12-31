import { Component, Input, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';
import { PostService } from 'src/app/services/post.service';
import { RecentDateService } from 'src/app/services/recent-date.service';

import Person from 'src/app/models/person';
import Post from 'src/app/models/post';
import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';
import { Router } from '@angular/router';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  loggedInUser: Person;
  posts: Set<Post>;
  adminPosts: Set<Post>;
  allUsers: Set<Person>;
  adminList: Boolean = false;
  userList: Boolean = false;
  updateUser = false;
  username: string;
  password: string;
  passwordCheck: string;
  company: string;
  email: string;
  updatedPerson: Person;

  constructor(
    private personService: PersonService,
    private postService: PostService,
    private recentDateService: RecentDateService,
    private sessionStorageWrapperService: SessionStorageWrapperService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loggedInUser = this.sessionStorageWrapperService.getLoggedUser();
    console.log('in [ProfileComponent]');
    console.log(this.loggedInUser);

    this.postService
      .retrieveUsersPosts(this.loggedInUser.id)
      .subscribe((resp) => {
        this.posts = this.recentDateService.sortDatesByMostRecentToLeastRecent(
          resp
        );
        for (let post of this.posts) {
          console.log(post);
        }
      });

    if (this.loggedInUser.role.name == 'admin') {
      this.postService.retrieveAllPosts().subscribe((resp) => {
        this.adminPosts = resp;
      });
      this.personService.getAllPersons().subscribe((resp) => {
        this.allUsers = resp;
      });
    }

    this.sessionStorageWrapperService.changeEmitted$.subscribe((person) => {
      if (!person) {
        this.router.navigate(['/']);
      }
    });
  }

  showAdminList() {
    this.adminList = true;
  }

  hideAdminList() {
    this.adminList = false;
  }

  showUserList() {
    this.userList = true;
  }

  hideUserList() {
    this.userList = false;
  }

  logout() {
    this.personService.logoutUser();
  }

  toggleUpdateUser() {
    if (!this.updateUser) {
      this.updateUser = true;
    } else {
      this.updateUser = false;
    }
    this.username = '';
    this.password = '';
    this.email = '';
    this.company = '';
  }

  updateUserInfo() {
    let u = '';
    let p = '';
    let e = '';
    let c = '';

    if (
      this.username != this.loggedInUser.username &&
      this.username.length > 0
    ) {
      u = this.username;
    } else {
      u = this.loggedInUser.username;
    }
    if (this.password != this.loggedInUser.passwd && this.password.length > 0) {
      p = this.password;
    } else {
      p = this.loggedInUser.passwd;
    }
    if (this.company != this.loggedInUser.company && this.company.length > 0) {
      c = this.company;
    } else {
      c = this.loggedInUser.company;
    }
    if (this.email != this.loggedInUser.email && this.email.length > 0) {
      e = this.email;
    } else {
      e = this.loggedInUser.email;
    }
    this.updatedPerson = {
      id: this.loggedInUser.id,
      username: u,
      passwd: p,
      company: c,
      email: e,
      role: this.loggedInUser.role,
    };
    console.log(
      this.loggedInUser.username + '<=old new=>' + this.updatedPerson.username
    );
    console.log(
      this.loggedInUser.passwd + '<=old new=>' + this.updatedPerson.passwd
    );
    console.log(
      this.loggedInUser.email + '<=old new=>' + this.updatedPerson.email
    );
    console.log(
      this.loggedInUser.company + '<=old new=>' + this.updatedPerson.company
    );
    this.personService.updateUser(this.updatedPerson);
    // window.location.reload();
  }
}
