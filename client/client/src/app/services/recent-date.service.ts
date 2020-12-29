import { Injectable } from '@angular/core';
import Post from 'src/app/models/post';

@Injectable({
  providedIn: 'root'
})
export class RecentDateService {

  constructor() { }

  sortDatesByMostRecentToLeastRecent (posts: Set<Post>): Set<Post>{

    let postsAsArray = Array.from(posts);
        //really complicated looking way to sort by date. Adheres to the way Post now has a predefined date object.
        //uses built-in array.sort method to compare year, month, day, hour, minute, and second.
        //negatives are necessary because otherwise this sorts by increasing order.
        //never mind
    postsAsArray.sort((a, b) => a.post_date.year - b.post_date.year !== 0 ? b.post_date.year - a.post_date.year :
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
}
