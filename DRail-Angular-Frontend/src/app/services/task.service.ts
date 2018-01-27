import { Injectable } from '@angular/core';
import { Task } from '../models/task';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
// import 'rxjs';
import { Tile } from '../models/tile';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class TaskService {
  private url = 'http://localhost:8080/api/viewtasks';

  constructor(private http: Http) { }

  getTasks (tile: Tile): Observable<Task[]> {
    return this.http
      .post(this.url, tile)
      .map((response: Response) => {
        return <Task[]> response.json();
      });
  }

}
