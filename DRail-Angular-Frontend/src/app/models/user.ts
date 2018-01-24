import { Role } from './role';

export class User {
    private _userId: number;
    private _username: string;
    private _password: string;
    private _firstname: string;
    private _lastname: string;
    private _email: string;
    private _stationRoleMap: Map<Number, Role>;


    constructor(userId: number, username: string, password: string,
                firstname: string, lastname: string, email: string, stationRoleMap: Map<Number, Role>) {
        this._userId = userId;
        this._username = username;
        this._password = password;
        this._firstname = firstname;
        this._lastname = lastname;
        this._email = email;
        this._stationRoleMap = stationRoleMap;
    }


    public get userId(): number {
        return this._userId;
    }

    public set userId(value: number) {
        if (value == null) { return; }
        this._userId = value;
    }

    public get username(): string {
        return this._username;
    }

    public set username(value: string) {
        if (value == null || value === '') { return; }
        this._username = value;
    }

    public get password(): string {
        return this._password;
    }

    public set password(value: string) {
        if (value == null) { return; }
        this._password = value;
    }

    public get firstname(): string {
        return this._firstname;
    }

    public set firstname(value: string) {
        if (value == null) { return; }
      this._firstname = value;
    }

    public get lastname(): string {
        return this._lastname;
    }

    public set lastname(value: string) {
        if (value == null) { return; }
        this._lastname = value;
    }

    public get email(): string {
        return this._email;
    }

    public set email(value: string) {
        if (value == null) { return; }
        this._email = value;
    }

    public get stationRoleMap(): Map<Number, Role> {
        return this._stationRoleMap;
    }

    public set stationRoleMap(value: Map<Number, Role>) {
        if (value == null) { return; }
        this._stationRoleMap = value;
    }

}
