import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import  Person  from '../models/person';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private loggedUser: Person; 
  private usersUrl: string;
  private formHeaders = new HttpHeaders({'Cookie':this.cookieService.get('JSESSIONID'),
    'Content-Type': 'application/x-www-form-urlencoded'});
  private regHeaders = new HttpHeaders({'Cookie':this.cookieService.get('JSESSIONID'),
    'Content-Type':'application/json'})

  constructor(private http: HttpClient, private urlService: UrlService, private cookieService: CookieService) {
    this.usersUrl = this.urlService.getUrl() + 'users';
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }

  loginUser(username: string, password: string): Observable<Person> {
    if (username && password) {
      const queryParams = `?user=${username}&pass=${password}`;
      return this.http.put(this.usersUrl + queryParams,
        {headers: this.formHeaders, withCredentials:true}).pipe(
          map(resp => resp as Person)
      ).pipe(
        catchError(this.handleError)
      );
    } else {
      return this.http.get(this.usersUrl,
        {withCredentials:true}).pipe(
          map(resp => resp as Person)
        );
    }
  }

  logoutUser(): Observable<object> {
    return this.http.delete(this.usersUrl, {headers:this.regHeaders, withCredentials:true}).pipe();
  }

  updateUser(updatedUser: Person): Observable<object> {
    this.loggedUser = updatedUser;
    return this.http.put(this.usersUrl + this.loggedUser.id, updatedUser, 
      {headers:this.regHeaders, withCredentials:true}).pipe();
  }

  getLoggedUser(): Person
  {
    return this.loggedUser;
  }

  getPersonByUsername(username: string): Observable<Person>{
    return this.http.get(this.usersUrl + username,
      {withCredentials:true}).pipe(
        map(resp => resp as Person)
    );
  }

}

