import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import Message from '../models/message';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private messageUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService) {
    this.messageUrl = this.urlService.getUrl() + 'message';
   }

   createNewMessage(message_text: string, sender_id: number, receiver_id: number): Observable<Message> {
    let newMessage : Message = new Message();
    newMessage.message_text = message_text;
    newMessage.sender_id = sender_id;
    newMessage.receiver_id = receiver_id;

    return this.http.post(this.messageUrl, newMessage, {withCredentials: true}).pipe(
      map(resp => resp as Message)
    );
   }

   /**
    * So the idea is that a reply will just create a new message rather
    * than to create a message chain. We may need to add a status feature
    * to the messages so that we can toggle their visibility
    */
}
