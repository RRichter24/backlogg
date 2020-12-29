export default class Comment {
    id : number;
    content: string;
    person_id: number;
    post_id: number;
    date: {
        year: number,
        monthValue: number,
        dayOfMonth: number,
        hour: number,
        minute: number,
        second: number
    };
}
