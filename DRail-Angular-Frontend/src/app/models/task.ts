export class Task {
    public taskId: number;
    public name: string;
    public completed: boolean;
    public order: number;
    public tildId: number;

    constructor(taskId: number, name: string, completed: boolean, order: number, tileId) {
        this.taskId = taskId;
        this.name = name;
        this.completed = completed;
        this.order = order;
        this.tildId = tileId;
    }
}
