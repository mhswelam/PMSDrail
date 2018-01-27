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
  private url = 'http://localhost:8080/api';

  private selectedStation: Station;
  // List of tiles (?) for creating burndown chart

  constructor(private http: Http) { }

  // Get all rails on this station
  getRails (station: Station): Observable<Rail[]> {
    return this.http
      .post(`${this.url}/viewrails`, station)
      .map((response: Response) => <Rail[]> response.json());
      // .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getStation(station: Station): Observable<Station> {
    return this.http
      .post(`${this.url}/viewstation`, station)
      .map((response: Response) => <Station> response.json());
  }

  // Set the given station as selected
  select(station: Station) {
    this.selectedStation = station;
  }

  // Remove current selection
  remove() {
    this.selectedStation = null;
  }

  // Get the selected station
  selected() {
    return this.selectedStation;
  }

}
