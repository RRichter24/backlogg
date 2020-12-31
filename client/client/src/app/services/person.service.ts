import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { UrlService } from './url.service';
import Person from '../models/person';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';
import { ErrorhandlingService } from './errorhandling.service';

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  private loggedUser: Person;
  private usersUrl: string;
  private formHeaders = new HttpHeaders({
    Cookie: this.cookieService.get('JSESSIONID'),
    'Content-Type': 'application/x-www-form-urlencoded',
  });
  private regHeaders = new HttpHeaders({
    Cookie: this.cookieService.get('JSESSIONID'),
    'Content-Type': 'application/json',
  });

  constructor(
    private http: HttpClient,
    private urlService: UrlService,
    private cookieService: CookieService,
    private errorhandlingService: ErrorhandlingService
  ) {
    this.usersUrl = this.urlService.getUrl() + 'users';
  }

  loginUser(username: string, password: string): Observable<Person> {
    const queryParams = `?user=${username}&pass=${password}`;
    return this.http
      .put(this.usersUrl + queryParams, {
        headers: this.formHeaders,
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp as Person),
        catchError(this.errorhandlingService.handleError)
      );
  }

  logoutUser(): Observable<object> {
    return this.http
      .delete(this.usersUrl, {
        headers: this.regHeaders,
        withCredentials: true,
      })
      .pipe(catchError(this.errorhandlingService.handleError));
  }

  updateUser(updatedUser: Person): Observable<object> {
    console.log("hello and welcome to the person service.  you sent: " + updatedUser.id + " " + updatedUser.username + updatedUser.passwd + " " +  + updatedUser.company + " " +  + updatedUser.email + " " )
    this.loggedUser = updatedUser;
    console.log("And now are about to send this: " + this.loggedUser.id+" " +this.loggedUser.username+" " +this.loggedUser.passwd+" " +this.loggedUser.company+" " +this.loggedUser.email+" ")
    return this.http
      .put(this.usersUrl +'/' +this.loggedUser.id, this.loggedUser, {
        headers: this.regHeaders,
        withCredentials: true,
      })
      .pipe(catchError(this.errorhandlingService.handleError));
  }

  getLoggedUser(): Person {
    return this.loggedUser;
  }

  getPersonByUsername(username: string): Observable<Person> {
    return this.http
      .get(this.usersUrl + '/username/' + username, { withCredentials: true })
      .pipe(map((resp) => resp as Person));
  }

  getPersonById(id: number): Observable<Person> {
    return this.http
      .get(this.usersUrl + '/' + id, { withCredentials: true })
      .pipe(map((resp) => resp as Person));
  }

  getAllPersons(): Observable<Set<Person>> {
    return this.http
      .get(this.usersUrl + '/all', {withCredentials: true})
      .pipe(map((resp) => resp as Set<Person>));
  }

}
