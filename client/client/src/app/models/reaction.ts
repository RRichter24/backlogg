import Person from "./person";
import Post from "./post";
import ReactionType from "./reaction-type";

export default class Reaction {
    id!: number;
    reaction_type_id!: number;
    person_id!: number;
    post_id!: number;
}
