import { Component, OnInit } from '@angular/core';
import Person from 'src/app/models/person';
import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  isUserLoggedIn: boolean;
  constructor(
    private sessionStorageWrapperService: SessionStorageWrapperService
  ) {}

  ngOnInit(): void {
    this.sessionStorageWrapperService.changeEmitted$.subscribe((person) => {
      if (person) {
        this.isUserLoggedIn = true;
      } else {
        this.isUserLoggedIn = false;
      }
    });
  }

  logout() {
    this.sessionStorageWrapperService.setLoggedUser(null);
  }
}
