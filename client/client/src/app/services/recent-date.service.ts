import { Injectable } from '@angular/core';
import Post from 'src/app/models/post';
import Comment from 'src/app/models/comment';

@Injectable({
  providedIn: 'root'
})
export class RecentDateService {

  constructor() { }

  

  sortPostDatesByMostRecentToLeastRecent (posts: Set<Post>): Set<Post>{
    //note: what i'm about to do may contradict generics best practices.
    //not checking is bad. forcing the T to be a type is even worse.


    let postsAsArray = Array.from(posts);
        //really complicated looking way to sort by date. Adheres to the way Post now has a predefined date object.
        //uses built-in array.sort method to compare year, month, day, hour, minute, and second.
        //negatives are necessary because otherwise this sorts by increasing order.
        //never mind
    postsAsArray.sort((a, b) => 
                              
                                a.post_date.year - b.post_date.year !== 0 ? b.post_date.year - a.post_date.year :
                                (
                                  a.post_date.monthValue - b.post_date.monthValue !== 0 ? b.post_date.monthValue - a.post_date.monthValue :
                                  (
                                    a.post_date.dayOfMonth - b.post_date.dayOfMonth !== 0 ? b.post_date.dayOfMonth - a.post_date.dayOfMonth :
                                    (
                                      a.post_date.hour - b.post_date.hour!== 0 ? b.post_date.hour - a.post_date.hour :
                                      (
                                        a.post_date.minute - b.post_date.minute !== 0 ? b.post_date.minute - a.post_date.minute :
                                        (
                                          b.post_date.second - a.post_date.second
                                        )
                                      )
                                    )
                                  )
                                ) 
                      );

    let sortedPosts = new Set(postsAsArray);

    return sortedPosts;
  }

  sortCommentDatesByMostRecentToLeastRecent (comments: Set<Comment>): Set<Comment>{
    //note: what i'm about to do may contradict generics best practices.
    //not checking is bad. forcing the T to be a type is even worse.


    let commentsAsArray = Array.from(comments);
        //really complicated looking way to sort by date. Adheres to the way Post now has a predefined date object.
        //uses built-in array.sort method to compare year, month, day, hour, minute, and second.
        //negatives are necessary because otherwise this sorts by increasing order.
        //never mind
    commentsAsArray.sort((a, b) => 
                              
                                a.date.year - b.date.year !== 0 ? b.date.year - a.date.year :
                                (
                                  a.date.monthValue - b.date.monthValue !== 0 ? b.date.monthValue - a.date.monthValue :
                                  (
                                    a.date.dayOfMonth - b.date.dayOfMonth !== 0 ? b.date.dayOfMonth - a.date.dayOfMonth :
                                    (
                                      a.date.hour - b.date.hour!== 0 ? b.date.hour - a.date.hour :
                                      (
                                        a.date.minute - b.date.minute !== 0 ? b.date.minute - a.date.minute :
                                        (
                                          b.date.second - a.date.second
                                        )
                                      )
                                    )
                                  )
                                ) 
                      );

    let sortedComments = new Set(commentsAsArray);

    return sortedComments;

  }


}
