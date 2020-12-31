import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthComponent } from './auth.component';

import { PersonService } from '../../services/person.service';
import { SessionStorageWrapperService } from '../../services/session-storage-wrapper.service';
import { Router } from '@angular/router';
import { MockAuth } from './auth.component.mock';

describe('AuthComponent', () => {
  let component: AuthComponent;
  let fixture: ComponentFixture<AuthComponent>;
  let personService: PersonService;
  let ssws: SessionStorageWrapperService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthComponent ],
      providers: [
        { provide: PersonService, useClass: MockAuth },
        { provide: SessionStorageWrapperService, useClass: MockAuth },
        { provide: Router, useClass: MockAuth}
      ]
    })
    .compileComponents();

    component = TestBed.inject(AuthComponent);
    personService = TestBed.inject(PersonService);
    ssws = TestBed.inject(SessionStorageWrapperService);

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('can determine whether you can log in', () => {
    component.username = '';
    component.password = '';
    component.validateInput();
    expect(component.btnStyle).toBe("btn btn-lg btn-primary btn-block disabled");

    component.username = 'karma police, arrest this man';
    component.password = 'he talks in maths. he buzzes like a fridge';
    component.validateInput();
    expect(component.btnStyle).toBe("btn btn-lg btn-primary btn-block");
  });

  it('can log a valid user in', () => {
    component.onSignIn();
    expect(ssws.getLoggedUser().passwd).toBe("walrein");
  })

});
