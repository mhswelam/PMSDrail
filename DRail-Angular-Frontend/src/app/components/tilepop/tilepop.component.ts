import { Component } from '@angular/core';
import { DialogComponent, DialogService } from 'ng2-bootstrap-modal';
import { Tile } from '../../models/tile';
import { TaskService } from '../../services/task.service';
import { Task } from '../../models/task';
import { TileService } from '../../services/tile.service';
import { Response } from '@angular/http/src/static_response';
import { ValidatorFn, Validators } from '@angular/forms';

export interface ConfirmModel  {

  tileObj: Tile;

}

@Component({
  selector: 'app-tilepop',
  templateUrl: './tilepop.component.html',
  styleUrls: ['./tilepop.component.css']
})
export class TilepopComponent extends DialogComponent<ConfirmModel, boolean> implements ConfirmModel {

  tileObj: Tile;

  constructor(dialogService: DialogService, private taskSer: TaskService, private tailSer: TileService) {
    super(dialogService);
 }

 confirm() {
  // we set dialog result as true on click on confirm button,
  // then we can get dialog result from caller code
  this.result = true;
  this.close();
}
tailCompleated() {
  this.tileObj.completed =  this.tileObj.completed ? false : true;
  this.tailSer.updateTile(this.tileObj).subscribe();
}

taskIdUpdated(id: number, flag: boolean) {
 let task: Task = new Task(id, '', null, 0, 0);
 task.taskId = id;
 this.taskSer.getTask(task).subscribe(
          data => {task = data; task.completed = flag;
          this.updateTaskInfo(task);  });


}

taskNameUpdated(id: number, taskName: string) {
  let task: Task = new Task(id, '', null, 0, 0);
  if (taskName.length > 0) {
    this.taskSer.getTask(task).subscribe(
      data => {task = data; task.name = taskName;
      this.updateTaskInfo(task);  });
  } else {

  }


}

updateTaskInfo(task: Task) {
  this.taskSer.updateTask(task).subscribe();
}

}
