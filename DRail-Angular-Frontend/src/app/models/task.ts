export class Task {
    private _taskId: number;
    private _name: string;
    private _completed: boolean;
    private _order: number;
    private _tildId: number;

    constructor(taskId: number, name: string, completed: boolean, order: number, tileId) {
        this._taskId = taskId;
        this._name = name;
        this._completed = completed;
        this._order = order;
        this._tildId = tileId;
    }


    public get taskId(): number {
        return this._taskId;
    }

    public set taskId(value: number) {
        if (value == null) { return; }
        this._taskId = value;
    }

    public get name(): string {
        return this._name;
    }

    public set name(value: string) {
        if (value == null || value === '') { return; }
        this._name = value;
    }

    public get completed(): boolean {
        return this._completed;
    }

    public set completed(value: boolean) {
        if (value == null) { return; }
        this._completed = value;
    }

    public get order(): number {
        return this._order;
    }

    public set order(value: number) {
        if (value == null) { return; }
        this._order = value;
    }

    public get tildId(): number {
        return this._tildId;
    }

    public set tildId(value: number) {
        if (value == null) { return; }
        this._tildId = value;
    }
}
