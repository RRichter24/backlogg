import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { ErrorhandlingService } from './errorhandling.service';
import Reaction from '../models/reaction';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ReactionService {
  baseUrl: string;

  constructor(
    private http: HttpClient,
    private urlService: UrlService,
    private errorhandlingService: ErrorhandlingService
  ) {
    this.baseUrl = this.urlService.getUrl() + 'reaction/';
  }

  submitReaction(reaction: Reaction): Observable<Reaction> {
    return this.http
      .post(this.baseUrl, reaction, {
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp as Reaction),
        catchError(this.errorhandlingService.handleError)
      );
  }

  deleteReaction(reactionid: number): Observable<any> {
    return this.http
      .delete(this.baseUrl + `reactionid/${reactionid}`, {
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp),
        catchError(this.errorhandlingService.handleError)
      );
  }

  fetchReactions(postid: number): Observable<Set<Reaction>> {
    return this.http
      .get(this.baseUrl + `postid/${postid}`, {
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp as Set<Reaction>),
        catchError(this.errorhandlingService.handleError)
      );
  }
}
