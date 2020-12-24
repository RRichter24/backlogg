import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import  Post  from '../models/post';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';
import { NewPostComponent } from '../components/new-post/new-post.component';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private postsUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService) { 
    this.postsUrl = this.urlService.getUrl() + 'posts';
  }
  submitNewPost(posttext: String, posterId: Number): Observable<Post> {
    return this.http.post(this.postsUrl, {withCredentials: true}).pipe(
      map(resp => resp as Post)
    );
  }
}
