import { Injectable } from '@angular/core';
import {User} from '../models/user';
import { Http, Response } from '@angular/http';

@Injectable()
export class UserService {

  private user: User = null;
  constructor(private http: Http) { }

  getUser() {
    return this.user;
  }

  setUser(user: User) {
    this.user = user;
  }

  refreshUser() {
    console.log(this.user);
    this.http.post('http://localhost:8080/api/getuser', this.user, { withCredentials: true })
      .map((response: Response) => <User> response.json())
      .subscribe( data => this.user = data);
  }

}
