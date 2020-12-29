import { core } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import comment from 'src/app/models/comment';
import Post from 'src/app/models/post';
import reaction from 'src/app/models/reaction';
import { ImageService } from 'src/app/services/image.service';

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

  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

  constructor(private imageService: ImageService) {}

  // Should fetch image, comments, and reactions
  // on init
  ngOnInit(): void {
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
  }
}
