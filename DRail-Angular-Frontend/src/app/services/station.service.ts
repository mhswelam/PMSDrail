import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Station } from '../models/station';
import { Rail } from '../models/rail';

// import 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Router } from '@angular/router';
import { StationComponent } from '../components/station/station.component';


@Injectable()
export class StationService {
  private url = 'http://localhost:8080/api';

  private selectedStation: Station;
  // List of tiles (?) for creating burndown chart

  constructor(private http: Http, private router: Router) { }

  // Get all rails on this station
  getRails(station: Station): Observable<Rail[]> {
    return this.http
      .post(`${this.url}/viewrails`, station, { withCredentials: true })
      .map((response: Response) => <Rail[]>response.json());
    // .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  saveRailOrder(station: Station) {
    return this.http
      .post(`${this.url}/updaterailorder`, station, { withCredentials: true }).subscribe();
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

  getStation(station) {
    return this.http
      .post(`${this.url}/viewstation`, station, { withCredentials: true })
      .map((response: Response) => response.json());
  }

  refresh() {
    return this.http
      .post(`${this.url}/viewstation`, this.selectedStation, { withCredentials: true })
      .map((response: Response) => response.json())
      .subscribe(st => {
        this.selectedStation = st;
        StationComponent.refreshStation.next(true); // here!
        this.router.navigate(['station/test']);
      });
  }
}
