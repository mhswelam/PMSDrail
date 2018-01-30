import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { ChartOut } from '../models/chartout';
import { ChartIn } from '../models/chartin';

@Injectable()
export class ChartService {

  private url = 'http://localhost:8080/api';

  constructor(private http: Http) { }


  getChart(chartout: ChartOut): Observable<ChartIn> {
    return this.http
      .post(`${this.url}/viewchart`, chartout , { withCredentials: true })
      .map((response: Response) => <ChartIn> response.json());
  }

}
