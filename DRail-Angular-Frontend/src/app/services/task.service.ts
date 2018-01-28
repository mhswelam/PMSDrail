import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Task } from '../models/task';

@Injectable()
export class TaskService {

  private url = 'http://localhost:8080/api';

  constructor(private http: Http) { }


  updateTask(task: Task) {
    return this.http
      .post(`${this.url}/updatetask`, task , { withCredentials: true });
  }

  addTask(task: Task) {
    return this.http
      .post(`${this.url}/addtask`, task , { withCredentials: true });
  }

  getTask(task: Task): Observable<Task> {
    return this.http
      .post(`${this.url}/viewtask`, task , { withCredentials: true })
      .map((response: Response) => <Task> response.json());
  }

}
