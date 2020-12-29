import { RequestStatus } from "./request-status";

export class FriendRequest {
    id: number;
    person1_id: number;
    person2_id: number;
    request_status: RequestStatus;
}
