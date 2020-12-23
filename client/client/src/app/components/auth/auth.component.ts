import { Component, Injector, OnInit} from '@angular/core';
import { browser } from 'protractor';
import { Person } from '../../models/person';
import { SiginService } from '../../services/sigin.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  username: string = '';
  password: string = '';
  private isValidUsername: boolean = false; 
  private isValidPassword: boolean = false; 

  btnStyle: String = "btn btn-lg btn-primary btn-block disabled"; 

  constructor(private injector: Injector) { }

  validateInput() {
    console.log("validating..."); 
    let canSignIn : boolean = true; 
    if ( this.username.length === 0 ) {
      canSignIn = false; 
    } 

    if ( this.password.length === 0 ) {
      canSignIn = false; 
    }

    console.log(canSignIn);
    if (canSignIn) {
      console.log('here');
      this.btnStyle = "btn btn-lg btn-primary btn-block";
    } else {
      this.btnStyle = "btn btn-lg btn-primary btn-block disabled";
    }
  }

  async onSignIn() {
    console.log(this.username, this.password);
    const signinServ = this.injector.get(SiginService);
    let person = await signinServ.getPersonByUsername(this.username, this.password); 
    console.log(person);
  }

  ngOnInit(): void {
  }

}
