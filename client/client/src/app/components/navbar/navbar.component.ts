import { Component, OnInit } from '@angular/core';
import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  constructor(sessionStorageWrapperService: SessionStorageWrapperService) {}

  ngOnInit(): void {}
}
