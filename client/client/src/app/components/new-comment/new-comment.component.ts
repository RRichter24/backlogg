import { Component, Input, OnInit } from '@angular/core';
import Person from 'src/app/models/person';
import Comment from 'src/app/models/comment';
import Post from 'src/app/models/post';
import { CommentService } from 'src/app/services/comment.service';

@Component({
  selector: 'app-new-comment',
  templateUrl: './new-comment.component.html',
  styleUrls: ['./new-comment.component.css'],
})
export class NewCommentComponent implements OnInit {
  @Input() post: Post;
  loggedInUser: Person;
  text: string;

  constructor(private commentService: CommentService) {}

  ngOnInit(): void {
    this.loggedInUser = JSON.parse(sessionStorage.getItem('loggedInUser'));
    this.text = '';
  }

  submitComment() {
    console.log(this.text);
    console.log(this.loggedInUser.id);

    let newComment = new Comment();
    newComment.post_id = this.post.id;
    newComment.person_id = this.loggedInUser.id;
    newComment.content = this.text;

    this.commentService.submitNewComment(newComment).subscribe((resp) => {
      console.log(resp);
    });
    window.location.reload();
  }
  
}
