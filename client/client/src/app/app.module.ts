import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './components/auth/auth.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { NewPostComponent } from './components/new-post/new-post.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';

import { CookieService } from 'ngx-cookie-service';
import { MessageComponent } from './components/message/message.component';
import { NewsfeedComponent } from './components/newsfeed/newsfeed.component';
import { FriendRequestComponent } from './components/friend-request/friend-request.component';
import { PostComponent } from './components/post/post.component';
import { NewCommentComponent } from './components/new-comment/new-comment.component';
import { CommentComponent } from './components/comment/comment.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    NavbarComponent,
    HomeComponent,
    NewPostComponent,
    ProfileComponent,
    SignUpComponent,
    MessageComponent,
    NewsfeedComponent,
    FriendRequestComponent,
    PostComponent,
    NewCommentComponent,
    CommentComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [CookieService],
  bootstrap: [AppComponent],
})
export class AppModule {}
