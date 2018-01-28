import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Task } from '../models/task';
import { Tile } from '../models/tile';

@Injectable()
export class TileService {

  private url = 'http://localhost:8080/api';

  constructor(private http: Http) { }


  addTile(tile: Tile) {
    return this.http
      .post(`${this.url}/addtile`, tile, { withCredentials: true});
  }

  getTileInfo(tile: Tile): Observable<Tile> {
    return this.http
      .post(`${this.url}/viewtile`, tile , { withCredentials: true })
      .map((response: Response) => <Tile> response.json());
  }

  updateTile(tile: Tile) {
    return this.http
      .post(`${this.url}/updatetile`, tile , { withCredentials: true });
  }
}
