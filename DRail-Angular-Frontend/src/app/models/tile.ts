export class Tile {
    public tileId: number;
    public name: string;
    public points: number;
    public note: string;
    public dateCompleted: number; // <- Hoping to represent this as a Long in Java...
    public completed: boolean;
    public order: number;
    public userCheckedOutId: number;
    public railId: number;
    public taskIds: number[];

    constructor(tileId: number, name: string, points: number, note: string,
                dateCompleted: number, completed: boolean, order: number,
                userCheckedOutId: number, railId: number, taskIds: number[]) {
        this.tileId = tileId;
        this.name = name;
        this.points = points;
        this.note = note;
        this.dateCompleted = dateCompleted;
        this.completed = completed;
        this.order = order;
        this.userCheckedOutId = userCheckedOutId;
        this.railId = railId;
        this.taskIds = taskIds;
    }

}
