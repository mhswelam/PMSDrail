import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { User } from '../models/user';




@Injectable()
export class LoginService {

  private url = 'http://localhost:8080/api/login';

  constructor(private http: Http) { }

  

}
