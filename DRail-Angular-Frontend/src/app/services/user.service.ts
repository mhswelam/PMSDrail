import { Injectable } from '@angular/core';
import {User} from '../models/user';

@Injectable()
export class UserService {

  private user: User = null;
  constructor() { }

  getUser() {
    return this.user;
  }

  setUser(user: User) {
    this.user = user;
  }

}
