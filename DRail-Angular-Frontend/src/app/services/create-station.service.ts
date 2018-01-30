import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { StationComponent } from '../components/station/station.component';
import { Station } from '../models/station';
import { StationsComponent } from '../components/stations/stations.component';
import { Router } from '@angular/router';
import { Response } from '@angular/http/src/static_response';
//import { Response } from '_debugger';

@Injectable()
export class CreateStationService {

  private url = 'http://localhost:8080/api';

  constructor(private http: Http, private router: Router) { }

  createStation(station: Station) {
    return this.http
        .post(`${this.url}/addstation`, station, { withCredentials: true })
        .map((response: Response) => <Station> response.json());
  }

  refresh() {
        StationsComponent.refreshStations.next(true);
        this.router.navigate(['stations']);
      // .map((response: Response) => <Stations> response.json());
  }

}
