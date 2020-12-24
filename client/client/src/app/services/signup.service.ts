import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
// import { CookieService } from 'ngx-cookie-service';

import { UrlService } from './url.service';


@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  baseUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService) {
    this.baseUrl = this.urlService.getUrl() + "/users"; 
  }
  
  registerAUser(username: String, password: String): Observable<object>{
    return this.http.post(this.baseUrl, {withCredentials: true}).pipe();
  }
  
}
