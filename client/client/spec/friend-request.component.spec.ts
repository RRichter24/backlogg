import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClient, HttpHandler } from '@angular/common/http';


import { FriendRequestComponent } from 'src/app/components/friend-request/friend-request.component';

describe('FriendRequestComponent', () => {
  let component: FriendRequestComponent;
  let fixture: ComponentFixture<FriendRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FriendRequestComponent ],
      providers: [HttpClient, HttpHandler]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create friend requests', () => {
    expect(component).toBeTruthy();
  });
});
