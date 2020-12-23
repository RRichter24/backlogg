import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Person } from '../models/person';  

@Injectable({
  providedIn: 'root'
})
export class SiginService {

  constructor(private http: HttpClient) {}

  // TODO: review url/endpoints 
  getPersonByUsername(username: String): Observable<Person> {
    return this.http.get(`https://backlogg/api/getPersonByUsername${username}`).pipe(
      map(resp => resp as Person)
    )
  }
}
