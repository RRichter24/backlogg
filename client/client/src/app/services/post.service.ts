import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import  Post  from '../models/post';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private postsUrl: string;
  private multiplePostsUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService) { 
    this.postsUrl = this.urlService.getUrl() + 'post';
    this.multiplePostsUrl = this.urlService.getUrl() + 'posts';
  }

  submitNewPost(posttext: string, posterId: number): Observable<Post> {
    let postToSubmit: Post = new Post();
    postToSubmit.person_id = posterId;
    postToSubmit.post_text = posttext;
    console.log(posttext);
    console.log(posterId);
    return this.http.post(this.postsUrl, postToSubmit, {withCredentials: true}).pipe(

      map(resp => resp as Post)
    );
  }

  retrieveUsersPosts(userId: number): Observable<Set<Post>> {
    return this.http.get(this.multiplePostsUrl + "/user/" + userId, {withCredentials: true}).pipe(
      map(resp => resp as Set<Post>)
    );
  }
  
}
