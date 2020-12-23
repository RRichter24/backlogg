import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor() { }

<<<<<<< HEAD:client/client/src/app/register-user/services/url.service.ts
  getUrl(): String {
=======
  public getUrl(): String {
>>>>>>> 057b3d728f039d2ee9a041e6a6474eef7409677b:client/client/src/app/components/register-user/services/url.service.ts
    return "jdbc:postgresql://usf2011.cjzzundlfqwz.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=backlogg/users";
  }
}
