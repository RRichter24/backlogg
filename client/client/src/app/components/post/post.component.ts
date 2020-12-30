import { core } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import comment from 'src/app/models/comment';
import Post from 'src/app/models/post';
import reaction from 'src/app/models/reaction';
import { CommentService } from 'src/app/services/comment.service';
import { ImageService } from 'src/app/services/image.service';
import { ReactionService } from 'src/app/services/reaction.service';
import { SessionStorageWrapperService } from 'src/app/services/session-storage-wrapper.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent implements OnInit {
  @Input() post: Post;

  imgURL: any;
  comments: Set<comment>;
  reactions: Set<reaction>;

  spicyRxns: number = 0;

  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

  constructor(
    private imageService: ImageService,
    private commentService: CommentService,
    private sessionStorageWrapperService: SessionStorageWrapperService,
    private reactionService: ReactionService
  ) {}

  // Should fetch image, comments, and reactions
  // on init
  ngOnInit(): void {
    // Fetch image associated with post
    this.imageService.download(this.post.id).subscribe(
      (res) => {
        console.log(res);
        this.receivedImageData = res;
        this.base64Data = this.receivedImageData.pic;

        if (this.base64Data === undefined) {
          console.log('not fetch pic data');
        }
        this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data;
      },
      (err) => console.log('Error Occured duringng saving: ' + err)
    );

    // Fetch comments associated with post
    this.commentService.getCommentsByPostId(this.post.id).subscribe((res) => {
      console.log(res);
      this.comments = res;
    });
  }

  //   export default class Reaction {
  //     id: number;
  //     reaction_type_id: number;
  //     person_id: number;
  //     post_id: number;
  // }
  spicyReact(): void {
    let spicyReact = new reaction();
    spicyReact.reaction_type_id = 1; // Assuming spicy_reaction_type.id = 1
    spicyReact.post_id = this.post.id;
    spicyReact.person_id = this.sessionStorageWrapperService.getLoggedUser().id;

    this.reactionService.submitReaction(spicyReact).subscribe((resp) => {
      console.log(resp);
      this.spicyRxns++;
    });
  }
}
