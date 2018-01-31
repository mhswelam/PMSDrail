export class Rail {
    public railId: number;
    public name: string;
    public order: number;
    public stationId: number;
    public tileIds: number[];

    constructor(railId: number, name: string, order: number, stationId: number, tileIds: number[]) {
        this.railId = railId;
        this.name = name;
        this.order = order;
        this.stationId = stationId;
        this.tileIds = tileIds;
    }
}
