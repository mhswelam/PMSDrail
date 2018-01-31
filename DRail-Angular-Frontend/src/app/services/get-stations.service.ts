import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Station } from '../models/station';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Stations } from '../models/stations';


@Injectable()
export class GetStationsService {

  private url = 'http://localhost:8080/api/getstations';
  constructor(private http: Http ) { }

  getStations(): Observable<Stations> {
    return this.http.get(this.url, { withCredentials: true })
                    .map((response: Response) => <Stations> response.json());
  }


}
