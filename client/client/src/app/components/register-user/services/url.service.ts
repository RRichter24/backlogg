import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor() { }

  public getUrl(): String {
    return "jdbc:postgresql://usf2011.cjzzundlfqwz.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=backlogg/users";
  }
}
