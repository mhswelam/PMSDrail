import { Role} from '../models/role';
import { Injectable } from '@angular/core';
import {User} from '../models/user';
import { StationService } from './station.service';

@Injectable()
export class UserService {

  private user: User = null;

  constructor(private stationService: StationService) { }

  getUser() {
    return this.user;
  }

  setUser(user: User) {
    this.user = user;
  }

  getUsersRole(): Role {
    return this.user.stationRoleMap[this.stationService.selected().stationId];
  }
}
