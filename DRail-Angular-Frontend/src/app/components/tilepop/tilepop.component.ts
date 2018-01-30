import { Component } from '@angular/core';
import { DialogComponent, DialogService } from 'ng2-bootstrap-modal';
import { Tile } from '../../models/tile';
import { TaskService } from '../../services/task.service';
import { Task } from '../../models/task';
import { TileService } from '../../services/tile.service';
import { Response } from '@angular/http/src/static_response';
import { ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StationService } from '../../services/station.service';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { UserService } from '../../services/user.service';

export interface ConfirmModel {

  tileObj: Tile;

}

@Component({
  selector: 'app-tilepop',
  templateUrl: './tilepop.component.html',
  styleUrls: ['./tilepop.component.css']
})
export class TilepopComponent extends DialogComponent<ConfirmModel, boolean> implements ConfirmModel, OnInit {

  tileObj: Tile;
  editName = false;
  editPoints = false;
  name: string;
  points: number;

  constructor(dialogService: DialogService, private taskSer: TaskService, private tailSer: TileService,
    private activatedRoute: ActivatedRoute, private router: Router, private stationService: StationService,
     private userService: UserService) {
    super(dialogService);

  }

  ngOnInit() {
    this.name = this.tileObj.name;
  }

  confirm() {
    // we set dialog result as true on click on confirm button,
    // then we can get dialog result from caller code
    this.result = true;
    this.close();
  }
  tailCompleated() {
    this.tileObj.completed = this.tileObj.completed ? false : true;
    this.tailSer.updateTile(this.tileObj).subscribe();
  }

  taskIdUpdated(id: number, flag: boolean) {
    let task: Task = new Task(id, '', null, 0, 0);
    task.taskId = id;
    this.taskSer.getTask(task).subscribe(
      data => {
        task = data; task.completed = flag;
        this.updateTaskInfo(task);
      });


  }

  taskNameUpdated(id: number, taskName: string) {
    let task: Task = new Task(id, '', null, 0, 0);
    if (taskName.length > 0) {
      this.taskSer.getTask(task).subscribe(
        data => {
          task = data; task.name = taskName;
          this.updateTaskInfo(task);
        });
    } else {

    }

  }

  addNewTask(taskName: string) {
    if (taskName.length > 0) {
      let task: Task = new Task(0, taskName, null, this.tileObj.tasks.length, this.tileObj.tileId);
      this.taskSer.addTask(task).subscribe();
      this.tileObj.tasks.push(task);
      this.dialogService.addDialog(TilepopComponent, {
        tileObj: this.tileObj
      }).subscribe();
      this.close();
    }
  }

  updateTaskInfo(task: Task) {
    this.taskSer.updateTask(task).subscribe();
  }

  saveName() {
    this.editName = false;
    if (this.tileObj.name !== this.name) {
      this.tileObj.name = this.name;
      this.tailSer.updateTile(this.tileObj).subscribe(() => this.stationService.refresh());
    }
  }

  savePoints() {
    this.editPoints = false;
    if (this.tileObj.points !== this.points) {
      this.tileObj.points = this.points;
      this.tailSer.updateTile(this.tileObj).subscribe(() => this.stationService.refresh());
    }
  }

  setUserCheckedOut() {
    this.tileObj.userCheckedOutId = this.userService.getUser().userId;
    this.tailSer.updateTile(this.tileObj).subscribe(() => this.stationService.refresh());
  }

}
