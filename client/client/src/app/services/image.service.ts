import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { ErrorhandlingService } from './errorhandling.service';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root',
})
export class ImageService {
  private postsUrl: string;

  constructor(
    private http: HttpClient,
    private urlService: UrlService,
    private errorhandlingService: ErrorhandlingService
  ) {
    this.postsUrl = this.urlService.getUrl() + 'images';
  }

  upload(image: FormData): Observable<any> {
    return this.http
      .post('http://localhost:8080/backend/images/upload/postid/0', image, {
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp as any),
        catchError(this.errorhandlingService.handleError)
      );
  }
}
