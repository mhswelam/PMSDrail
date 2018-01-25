import { Injectable } from '@angular/core';
import { Http } from '@angular/http/src/http';
import { Observable } from 'rxjs/Observable';
import { Station } from '../models/station';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class GetStationsService {

  // stations array.
  private url = 'http://localhost:8080/api/getstations';
  constructor(private http: Http ) { }

  getStations(): Observable<Station[]> {
    return this.http.get(this.url)
                    .map((response: Response) => <Station[]> response.json);
  }


}
