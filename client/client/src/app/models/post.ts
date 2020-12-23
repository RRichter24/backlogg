import Person from "./person";

export default class Post {
    id!: number;
    post_text!: string;
    date!: Date;
    person!: Person;
}
