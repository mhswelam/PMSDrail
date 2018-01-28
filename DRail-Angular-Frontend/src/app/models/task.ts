export class Task {
    public taskId: number;
    public name: string;
    public completed: boolean;
    public order: number;
    public tileId: number;

    constructor(taskId: number, name: string, completed: boolean, order: number, tileId: number) {
        this.taskId = taskId;
        this.name = name;
        this.completed = completed;
        this.order = order;
        this.tileId = tileId;
    }
}
