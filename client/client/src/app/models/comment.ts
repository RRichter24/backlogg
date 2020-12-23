import  Person  from "./person";
import  Post  from "./post";

export default class Comment {
    id !: number;
    content!: string;
    person_id!: number;
    post_id!: number;
    date!: Date | object;
}
