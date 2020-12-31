import Person from './person';
import Post from './post';
import ReactionType from './reaction-type';

export default class Reaction {
  id: number;
  reaction_type: ReactionType;
  person_id: number;
  post_id: number;
}
