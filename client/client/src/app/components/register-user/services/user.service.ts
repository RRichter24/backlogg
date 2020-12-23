import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
// import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  // baseUrl: String = UrlService.getUrl();

  /*
  private formHeaders = new HttpHeaders({'Cookie':this.cookieService.get('JSESSIONID'),
  'Content-Type': 'application/x-www-form-urlencoded'});
   private regHeaders = new HttpHeaders({'Cookie':this.cookieService.get('JSESSIONID'),
  'Content-Type':'application/json'})
  */


  // constructor(private http: HttpClient) { }

  /*
  registerAUser(username: String, password: String){
    if (username && password){
      whatever: String = + `users?username=${username}&password=${password}`;
      this.http.put(`jdbc:postgresql://usf2011.cjzzundlfqwz.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=backlogg/users?username=${username}&password=${password}`, {});
    }

  }
  */
}
