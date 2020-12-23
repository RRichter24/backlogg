import  Person  from "./person";

export default class Message {
    id!: number;
    message_text!: string;
    sender_id!: number;
    receiver_id!: number;
    date!: Date | object;
}
