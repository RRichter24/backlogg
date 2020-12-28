import { Component, OnInit } from '@angular/core';
import Person from 'src/app/models/person';
import { ImageService } from 'src/app/services/image.service';
import { PersonService } from 'src/app/services/person.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.css'],
})
export class NewPostComponent implements OnInit {
  loggedInUser: Person;
  text: string;

  // These are field associated with image uploads
  public selectedFile;
  public event1;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

  constructor(
    private personService: PersonService,
    private postService: PostService,
    private imageService: ImageService
  ) {}

  ngOnInit(): void {
    this.loggedInUser = JSON.parse(sessionStorage.getItem('loggedInUser'));
    this.text = '';
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };
  }

  submitPost() {
    console.log(this.text);
    this.postService.submitNewPost(this.text, 1).subscribe((resp) => {
      console.log(resp);
    });

    if (this.imgURL !== '') {
      this.uploadImage();
    }
  }

  // This part is for uploading
  uploadImage() {
    const uploadData = new FormData();
    uploadData.append('myFile', this.selectedFile, this.selectedFile.name);

    this.imageService.upload(uploadData).subscribe(
      (res) => {
        console.log(res);
        this.receivedImageData = res;
        this.base64Data = this.receivedImageData.pic;
        this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data;
      },
      (err) => console.log('Error Occured duringng saving: ' + err)
    );
  }
}
