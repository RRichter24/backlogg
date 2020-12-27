import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './components/auth/auth.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { HomeComponent } from './components/home/home.component';
import { MessageComponent } from './components/message/message.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: AuthComponent},
  {path: 'register', component: SignUpComponent},
  {path: 'messages', component: MessageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


}
