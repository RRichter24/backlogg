import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import  Person  from '../models/person';  

@Injectable({
  providedIn: 'root'
})
export class SiginService {

  constructor(private http: HttpClient) {}

  // TODO: review url/endpoints 
  getPersonByUsername(username: string, password: string): Observable<Person> {
    return this.http.put(`http://localhost:8081/users/${username}/${password}`, {}).pipe(
      map(resp => resp as Person)
    )
  }
}
