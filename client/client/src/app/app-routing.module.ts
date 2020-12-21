import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
    path: "user"
  },
  {},
  {},
  {}
  */
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


}
