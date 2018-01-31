import { Role } from './role';

export class Station {
    public stationId: number;
    public name: string;
    public timeCreated: number; // <- Time in milliseconds?
    public dueDate: number; // <- Time in milliseconds?
    public railIds: number[];
    public userRoleMap: Map<Number, Role>;

    constructor(stationId: number, name: string, timeCreated: number, dueDate: number,
        railIds: number[], userRoleMap: Map<Number, Role>) {
        this.stationId = stationId;
        this.name = name;
        this.timeCreated = timeCreated;
        this.dueDate = dueDate;
        this.railIds = railIds;
        this.userRoleMap = userRoleMap;
    }
}
