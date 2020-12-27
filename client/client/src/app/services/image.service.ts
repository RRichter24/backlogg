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
  constructor(
    private http: HttpClient,
    private urlService: UrlService,
    private errorhandlingService: ErrorhandlingService
  ) {}

  upload(image: FormData): Observable<any> {
    return this.http
      .post('http://localhost:8080/check/upload', image, {
        withCredentials: true,
      })
      .pipe(
        map((resp) => resp as any),
        catchError(this.errorhandlingService.handleError)
      );
  }
}
