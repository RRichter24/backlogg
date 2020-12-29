import Person from "./person";

export default class Post {
    id: number;
    post_text: string;
    post_date: Date | object;
    person_id: number;
}
