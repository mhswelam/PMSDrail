import { Role } from './role';

export class User {
    public userId: number;
    public username: string;
    public password: string;
    public firstname: string;
    public lastname: string;
    public email: string;
    public stationRoleMap: Map<Number, Role>;

    constructor(userId: number, username: string, password: string,
                firstname: string, lastname: string, email: string, stationRoleMap: Map<Number, Role>) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.stationRoleMap = stationRoleMap;
    }
}
