import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FriendRequest } from '../models/friend-request';
import { UrlService } from './url.service';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FriendRequestService {
  private friendRequestUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService) {
    this.friendRequestUrl = this.urlService.getUrl() + 'friend';
   }

   sendFriendRequest(person1_id: number, person2_id: number): Observable<FriendRequest>{
     let newRequest : FriendRequest = new FriendRequest();
     newRequest.person1_id = person1_id;
     newRequest.person2_id = person2_id;
     newRequest.request_status = {
      id: 1,
      name: 'pending'
     };

     return this.http.post(this.friendRequestUrl, newRequest, {withCredentials: true}).pipe(
       map(resp => resp as FriendRequest)
     );
   }

   acceptFriendRequest(id:number): Observable<FriendRequest>{

    return this.http.put(this.friendRequestUrl+"/"+id, {withCredentials:true}).pipe(
      map(resp => resp as FriendRequest)
    );
   }

   rejectFriendRequest(id:number): Observable<object>{
    return this.http.delete(this.friendRequestUrl+"/"+id, {withCredentials:true}).pipe();
   }

   getSentRequestsByPersonId(id:number):Observable<Set<FriendRequest>>{

    return this.http.get(this.friendRequestUrl+"/sent/"+id, {withCredentials:true}).pipe(
      map(resp=> resp as Set<FriendRequest>)
    );
   }

   getReceivedRequestsByPersonId(id:number):Observable<Set<FriendRequest>>{

    return this.http.get(this.friendRequestUrl+"/received/"+id, {withCredentials:true}).pipe(
      map(resp=> resp as Set<FriendRequest>)
    );
   }

}
