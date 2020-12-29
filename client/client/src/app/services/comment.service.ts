import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import comment from '../models/comment';
import Post from '../models/post';
import { ErrorhandlingService } from './errorhandling.service';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root',
})
export class CommentService {
  private commentsUrl: string;
  constructor(
    private http: HttpClient,
    private urlService: UrlService,
    private errorHandlingService: ErrorhandlingService
  ) {
    this.commentsUrl = this.urlService.getUrl() + 'comment';
  }

  submitNewComment(comment: comment): Observable<comment> {
    return this.http
      .post(this.commentsUrl, comment, {
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp as comment),
        catchError(this.errorHandlingService.handleError)
      );
  }

  getCommentsByPostId(postid: number): Observable<Set<comment>> {
    return this.http
      .get(this.commentsUrl + `/postid/${postid}`, {
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp as Set<comment>),
        catchError(this.errorHandlingService.handleError)
      );
  }
}
