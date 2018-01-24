export class Tile {
    private _tileId: number;
    private _name: string;
    private _points: number;
    private _note: string;
    private _dateCompleted: number; // <- Hoping to represent this as a Long in Java...
    private _completed: boolean;
    private _order: number;
    private _userCheckedOutId: number;
    private _railId: number;
    private _taskIds: number[];

    constructor(tileId: number, name: string, points: number, note: string,
                dateCompleted: number, completed: boolean, order: number,
                userCheckedOutId: number, railId: number, taskIds: number[]) {
        this._tileId = tileId;
        this._name = name;
        this._points = points;
        this._note = note;
        this._dateCompleted = dateCompleted;
        this._completed = completed;
        this._order = order;
        this._userCheckedOutId = userCheckedOutId;
        this._railId = railId;
        this._taskIds = taskIds;
    }

    get tileId(): number {
        return this._tileId;
    }
    set tileId(tileId: number) {
        if (tileId != null) {
            this.tileId = 0;
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

    get points(): number {
        return this._points;
    }
    set points(points: number) {
        if (points != null) {
            this._points = points;
        }
    }

    get note(): string {
        return this._note;
    }
    set note(note: string) {
        if (note != null && note !== '') {
            this._note = note;
        }
    }

    get dateCompleted(): number {
        return this._dateCompleted;
    }
    set dateCompleted(dateCompleted: number) {
        if (dateCompleted != null) {
            this._dateCompleted = dateCompleted;
        }
    }

    get completed(): boolean {
        return this._completed;
    }
    set completed(completed: boolean) {
        if (completed != null) {
            this._completed = completed;
        }
    }


    get order(): number{
        return this._order;
    }
    set order(order: number){
        if (order != null) {
            this._order = order;
        }
    }

    get userCheckedOutId(): number{
        return this._userCheckedOutId;
    }
    set userCheckedOutId(userCheckedOutId: number) {
        if (userCheckedOutId != null) {
            this._userCheckedOutId = userCheckedOutId;
        }
    }

    get railId(): number {
        return this.railId;
    }
    set railId(railId: number) {
        if (railId != null) {
            this._railId = railId;
        }
    }

    get taskIds(): number[] {
        return this.taskIds;
    }
    set taskIds(taskIds: number[]) {
        if (taskIds != null) {
            this._taskIds = taskIds;
        }
    }
}
