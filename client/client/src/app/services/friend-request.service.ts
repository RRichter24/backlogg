import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class FriendRequestService {
  private friendRequestUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService) {
    this.friendRequestUrl = this.urlService.getUrl() + 'friend';
   }

}
