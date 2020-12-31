import { core } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import comment from 'src/app/models/comment';
import Post from 'src/app/models/post';
import reaction from 'src/app/models/reaction';
import ReactionType from 'src/app/models/reaction-type';
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

  spicyRxns: Set<reaction> = new Set<reaction>();
  spicyRxnsCnt: number = this.spicyRxns.size;
  milkRxns: Set<reaction> = new Set<reaction>();
  milkRxnsCnt: number = this.milkRxns.size;
  latestRxn: reaction;

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

    // Fetch reactions associated with post
    this.reactionService.fetchReactions(this.post.id).subscribe(
      (resp) => {
        console.log(resp);
        console.log('postid for rxns: ' + this.post.id);
        console.log('size: ' + resp.size);
        for (let rxn of resp) {
          this.addReactionToSet(rxn);
          if (
            rxn.person_id ===
            this.sessionStorageWrapperService.getLoggedUser().id
          ) {
            this.latestRxn = rxn;
          }
        }
      },
      (error) => {
        console.log(error);
      }
    );

    // Fetch comments associated with post
    this.commentService.getCommentsByPostId(this.post.id).subscribe((res) => {
      console.log(res);
      this.comments = res;
    });
  }

  react(reaction_type_id: number): void {
    let rxn = new reaction();
    rxn.reaction_type = new ReactionType();
    rxn.reaction_type.id = reaction_type_id;
    rxn.post_id = this.post.id;
    rxn.person_id = this.sessionStorageWrapperService.getLoggedUser().id;

    console.log('rxn: ' + rxn);
    if (this.latestRxn !== undefined) {
      this.reactionService
        .deleteReaction(this.latestRxn.id)
        .subscribe((resp) => {
          console.log(resp);
          this.removeReactionFromSet(this.latestRxn);

          if (this.latestRxn.reaction_type.id !== rxn.reaction_type.id) {
            this.reactionService.submitReaction(rxn).subscribe((resp) => {
              console.log(resp);
              this.addReactionToSet(resp);
              this.latestRxn = resp;
            });
          } else {
            this.latestRxn = undefined;
          }
        });
    } else {
      this.reactionService.submitReaction(rxn).subscribe((resp) => {
        console.log(resp);
        this.addReactionToSet(resp);
        this.latestRxn = resp;
      });
    }
  }

  updateReactionCounts(): void {
    this.spicyRxnsCnt = this.spicyRxns.size;
    this.milkRxnsCnt = this.milkRxns.size;

    console.log(this.spicyRxnsCnt, this.milkRxnsCnt);
  }

  addReactionToSet(reaction: reaction): void {
    switch (reaction.reaction_type.id) {
      case 1:
        console.log(this.spicyRxns.add(reaction));
        this.updateReactionCounts();
        break;
      case 2:
        console.log(this.milkRxns.add(reaction));
        this.updateReactionCounts();
        break;
      default:
        console.log('unknown reaction_type_id: ' + reaction.reaction_type.id);
    }
  }

  removeReactionFromSet(reaction: reaction): void {
    switch (reaction.reaction_type.id) {
      case 1:
        console.log(this.spicyRxns.delete(reaction));
        this.updateReactionCounts();
        break;
      case 2:
        console.log(this.milkRxns.delete(reaction));
        this.updateReactionCounts();
        break;
      default:
        console.log('unknown reaction_type_id: ' + reaction.reaction_type.id);
    }
  }
}
