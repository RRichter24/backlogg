import  Person  from "./person";

export default class Message {
    id!: number;
    message_text!: string;
    sender!: Person;
    receiver!: Person;
    date!: Date;
}
