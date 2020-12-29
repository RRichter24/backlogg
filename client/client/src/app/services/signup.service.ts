import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
// import { CookieService } from 'ngx-cookie-service';

import { UrlService } from './url.service';
import Person from '../models/person';
import { ErrorhandlingService } from './errorhandling.service';

@Injectable({
  providedIn: 'root',
})
export class SignUpService {
  baseUrl: string;
  private allowOriginsHeaders = new HttpHeaders({'Access-Control-Allow-Origin': '*'});

  constructor(
    private http: HttpClient,
    private urlService: UrlService,
    private ErrorhandlingService: ErrorhandlingService
  ) {
    this.baseUrl = this.urlService.getUrl() + '/users';
  }

  registerAUser(newPerson: Person): Observable<object> {
    return this.http
      .post(this.baseUrl, newPerson, { withCredentials: true })
      .pipe(
        map((resp) => resp as Person),
        catchError(this.ErrorhandlingService.handleError)
      );
  }
}
