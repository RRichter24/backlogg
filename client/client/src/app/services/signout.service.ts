import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignoutService {

  constructor() { }

  logout(){
    sessionStorage.clear();
  }
}
