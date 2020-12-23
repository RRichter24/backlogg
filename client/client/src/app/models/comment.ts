import  Person  from "./person";
import  Post  from "./post";

export default class Comment {
    id !: number;
    content!: string;
    person!: Person;
    post!: Post;
    date!: Date;
}
