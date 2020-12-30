import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import Person from '../models/person';

@Injectable({
  providedIn: 'root',
})
export class SessionStorageWrapperService {
  constructor() {}

  private emitChangeSource = new Subject<any>();

  changeEmitted$ = this.emitChangeSource.asObservable();

  emitChange(change: any) {
    this.emitChangeSource.next(change);
  }

  setLoggedUser(person: Person): boolean {
    try {
      sessionStorage.setItem('loggedInUser', JSON.stringify(person));
      this.emitChange(person);
      return true;
    } catch (err) {
      console.log(err);
      return false;
    }
  }
  getLoggedUser(): Person {
    return JSON.parse(sessionStorage.getItem('loggedInUser'));
  }
}
