import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { User } from '../models/user';




@Injectable()
export class LoginService {

  private url = 'http://localhost:8080/api/login';

  constructor(private http: Http) { }

  validateUser(user: User): Observable<User> {

    return this.http.post(this.url, user, { withCredentials: true })
                    .map((response: Response) => <User> response.json());
  }
}
