import { Injectable } from '@angular/core';
import Person from '../models/person';

@Injectable({
  providedIn: 'root',
})
export class SessionStorageWrapperService {
  constructor() {}

  setLoggedInUser(person: Person): boolean {
    try {
      sessionStorage.setItem('loggedInUser', JSON.stringify(person));
      return true;
    } catch (err) {
      console.log(err);
      return false;
    }
  }
  get LoggedInUser(): Person {
    return JSON.parse(sessionStorage.getItem('loggedInUser'));
  }
}
