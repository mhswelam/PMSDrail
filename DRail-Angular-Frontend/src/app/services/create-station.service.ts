import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { StationComponent } from '../components/station/station.component';
import { Station } from '../models/station';

@Injectable()
export class CreateStationService {

  private url = 'http://localhost:8080/api';

  constructor(private http: Http) { }

  createStation(station: Station) {
    return this.http
        .post(`${this.url}/addstation`, station, { withCredentials: true }).subscribe();
  }

}
