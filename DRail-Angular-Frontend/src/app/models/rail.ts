export class Rail {
    private _railId: number;
    private _name: string;
    private _order: number;
    private _stationId: number;
    private _tileIds: number[];


    constructor(railId: number, name: string, order: number, stationId: number, tileIds: number[]) {
        this._railId = railId;
        this._name = name;
        this._order = order;
        this._stationId = stationId;
        this._tileIds = tileIds;
    }

    public get railId(): number {
        return this._railId;
    }

    public set railId(value: number) {
        this._railId = value;
    }

    public get name(): string {
        return this._name;
    }

    public set name(value: string) {
        this._name = value;
    }

    public get order(): number {
        return this._order;
    }

    public set order(value: number) {
        this._order = value;
    }

    public get stationId(): number {
        return this._stationId;
    }

    public set stationId(value: number) {
        this._stationId = value;
    }

    public get tileIds(): number[] {
        return this._tileIds;
    }

    public set tileIds(value: number[]) {
        this._tileIds = value;
    }
}
