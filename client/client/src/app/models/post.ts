
export default class Post {
    id: number;
    post_text: string;
    post_date: {
        year: number,
        monthValue: number,
        dayOfMonth: number,
        hour: number,
        minute: number,
        second: number
    };
    person_id: number;
}
