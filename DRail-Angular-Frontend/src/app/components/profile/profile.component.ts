import {User} from '../../models/user';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { ProfileService } from '../../services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profileMode: number;

  firstname: string;
  lastname: string;
  username: string;
  email: string;

  currentUser: User;

  constructor(protected userService: UserService, protected profileService: ProfileService) {
      this.currentUser = userService.getUser();
      this.firstname = this.currentUser.firstname;
      this.lastname = this.currentUser.lastname;
      this.username = this.currentUser.username;
      this.email = this.currentUser.email;
   }

  ngOnInit() {
    this.profileMode = 1;
  }

  public changeDisplay(val: number) {
    this.profileMode = val;
  }
}
