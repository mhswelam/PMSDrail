import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { User } from '../models/user';


@Injectable()
export class LogoutService {

  private url = 'http://localhost:8080/api/logout';

  constructor( private httpSer: Http) {

   }


   logout(): Observable<Response> {
    return this.httpSer.get(this.url, { withCredentials: true });
   }

}
