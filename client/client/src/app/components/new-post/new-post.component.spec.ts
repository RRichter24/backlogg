import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Component, OnInit } from '@angular/core';
import { ImageService } from 'src/app/services/image.service';
import { PersonService } from 'src/app/services/person.service';
import { PostService } from 'src/app/services/post.service';
import { NewPostComponent } from './new-post.component';
import { HttpClient } from '@angular/common/http';
import { HttpHandler } from '@angular/common/http';
import Person from 'src/app/models/person';

describe('NewPostComponent', () => {
  let component: NewPostComponent;
  let fixture: ComponentFixture<NewPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewPostComponent ],
      providers: [HttpClient, HttpHandler]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('can run submitPost() function', () => {
    component.loggedInUser = new Person();
    component.loggedInUser.id = 1;
    component.submitPost = jasmine.createSpy("agent");
    component.submitPost();
    expect(component.submitPost()).toHaveBeenCalled();
  });
});
