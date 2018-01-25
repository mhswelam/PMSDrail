import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Station } from '../models/station';
import { Rail } from '../models/rail';

// import 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class StationService {
  private url = 'http://localhost:8080/api/viewstation';

  constructor(private http: Http) { }

  getRails (station: Station): Observable<Rail[]> {
    return this.http
      .post(this.url, station)
      .map((response: Response) => {
        return <Rail[]> response.json();
      })
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

}
