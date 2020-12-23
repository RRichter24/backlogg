import Role from './role';

export class Person {
    id!: number;
    username!: string;
    password!: string;
    email!: string;
    company!: string;
    role!: Role;
}