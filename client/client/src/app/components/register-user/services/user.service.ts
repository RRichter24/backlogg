import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
<<<<<<< HEAD:client/client/src/app/register-user/services/user.service.ts
//import { CookieService } from 'ngx-cookie-service';

import { UrlService } from './url.service';
=======
// import { CookieService } from 'ngx-cookie-service';
>>>>>>> 057b3d728f039d2ee9a041e6a6474eef7409677b:client/client/src/app/components/register-user/services/user.service.ts


@Injectable({
  providedIn: 'root'
})
export class UserService {

<<<<<<< HEAD:client/client/src/app/register-user/services/user.service.ts
  //baseUrl: String = UrlService.getUrl();
=======
  // baseUrl: String = UrlService.getUrl();
>>>>>>> 057b3d728f039d2ee9a041e6a6474eef7409677b:client/client/src/app/components/register-user/services/user.service.ts

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
