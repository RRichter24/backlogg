import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './components/auth/auth.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { HomeComponent } from './components/home/home.component';
import { MessageComponent } from './components/message/message.component';
import { ProfileComponent } from './components/profile/profile.component';
import { FriendRequestComponent } from './components/friend-request/friend-request.component';
import { NewsfeedComponent } from './components/newsfeed/newsfeed.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: AuthComponent},
  {path: 'register', component: SignUpComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'message', component: MessageComponent},
  {path: 'request', component: FriendRequestComponent},
  {path: 'newsfeed', component: NewsfeedComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
