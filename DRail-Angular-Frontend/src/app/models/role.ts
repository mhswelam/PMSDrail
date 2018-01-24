export class Role {
    private _roleId: number;
    private _name: string;


    constructor(roleId: number, name: string) {
        this._roleId = roleId;
        this._name = name;
    }


    public get roleId(): number {
        return this._roleId;
    }

    public set roleId(value: number) {
        if (value == null) { return; }
        this._roleId = value;
    }

    public get name(): string {
        return this._name;
    }

    public set name(value: string) {
        if (value == null || value === '') { return; }
        this._name = value;
    }
}
