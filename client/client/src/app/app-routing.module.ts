import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './components/auth/auth.component';
import { HomeScreenComponent } from './components/home-screen/home-screen.component';

const routes: Routes = [
  {path: 'register', component: HomeScreenComponent},
  {path: 'signin', component: AuthComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
