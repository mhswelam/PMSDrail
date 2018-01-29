import {Http, Response} from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class ProfileService {

  private url = 'http://localhost:8080/api';
  private options: {};
  constructor(private http: Http) {
      this.options = {
        withCredentials: true
      };

  }

  updateUser(user: User) {
    return this.http.post(`${this.url}/updateuser`, user, this.options);
  }

}
