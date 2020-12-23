import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
<<<<<<< HEAD
import { HomeScreenComponent } from './home-screen/home-screen.component';

const routes: Routes = [
  {
    path: "",
    component: HomeScreenComponent
  },
  {
    path: "home",
    component: HomeScreenComponent
  }/*,
  {
    path: "user/home",
    component: UserHomeScreenComponent
  },
  {
    path: "admin/home",
    component: AdminHomeScreenComponent
  },
  {
    path: "user/profile",
    component: UserProfileScreenComponent
  },
  {}
  */
=======
import { AuthComponent } from './components/auth/auth.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: AuthComponent},
  {path: 'register', component: RegisterUserComponent},
>>>>>>> 057b3d728f039d2ee9a041e6a6474eef7409677b
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


}
