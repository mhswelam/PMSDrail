import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Rail } from '../models/rail';
import { Tile } from '../models/tile';

// import 'rxjs';
import 'rxjs/add/operator/map';

@Injectable()
export class RailService {
  private url = 'http://localhost:8080/api';

  constructor(private http: Http) { }

  getTiles(rail: Rail): Observable<Tile[]> {
    return this.http
      .post(`${this.url}/viewtiles`, rail, { withCredentials: true })
      .map((response: Response) => <Tile[]> response.json());
  }

  createRail(rail: Rail) {
    return this.http
      .post(`${this.url}/addrail`, rail, {withCredentials: true });
  }

  saveTileOrder(rails: Rail[]) {
    return this.http
      .post(`${this.url}/updatetileorder`, rails, { withCredentials: true }).subscribe();
  }

}
