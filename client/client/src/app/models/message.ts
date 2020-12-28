

export default class Message {
    id: number;
    message_text: string;
    sender_id: number;
    receiver_id: number;
    message_date: {
        monthValue: number,
        dayOfMonth: number,
        hour: number,
        minute: number
    };
}
