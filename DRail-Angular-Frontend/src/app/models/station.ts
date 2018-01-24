import { Role } from './role';

export class Station {
    private _stationId: number;
    private _name: string;
    private _timeCreated: number; // <- Time in milliseconds?
    private _dueDate: number; // <- Time in milliseconds?
    private _railIds: number[];
    private _stationRolesMap: Map<Number, Role>;

    constructor(stationId: number, name: string, timeCreated: number, dueDate: number,
        railIds: number[], stationRolesMap: Map<Number, Role>) {
        this._stationId = stationId;
        this._name = name;
        this._timeCreated = timeCreated;
        this._dueDate = dueDate;
        this._railIds = railIds;
        this._stationRolesMap = stationRolesMap;
    }

    get stationId(): number {
        return this._stationId;
    }
    set stationId(stationId: number) {
        if (stationId != null) {
            this._stationId = stationId;
        }
    }

    get name(): string {
        return this._name;
    }
    set name(name: string) {
        if (name != null && name !== '') {
            this._name = name;
        }
    }

    get timeCreated(): number {
        return this._timeCreated;
    }
    set timeCreate(timeCreated: number) {
        if (timeCreated != null) {
            this._timeCreated = timeCreated;
        }
    }

    get dueDate(): number {
        return this._dueDate;
    }
    set dueDate(dueDate: number) {
        if (dueDate != null) {
            this._dueDate = dueDate;
        }
    }

    get railIds(): number[] {
        return this._railIds;
    }
    set railIds(railIds: number[]) {
        if (railIds != null) {
            this._railIds = railIds;
        }
    }

    get stationRolesMap(): Map<Number, Role> {
        return this._stationRolesMap;
    }
    set stationRolesMap(stationRolesMap: Map<Number, Role>){
        if (stationRolesMap != null) {
            this._stationRolesMap = stationRolesMap;
        }
    }
}
