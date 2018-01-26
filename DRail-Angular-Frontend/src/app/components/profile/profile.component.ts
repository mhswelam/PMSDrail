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

  public isEditing = false;

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
  }

  public changeDisplay() {
    this.isEditing = !this.isEditing;
    if (this.isEditing) {
      document.getElementById('editButton').innerHTML = '<i class="fa fa-arrow-left"></i> &nbsp; Go Back';
    } else {
      document.getElementById('editButton').innerHTML = '<i class="fa fa-pencil"></i> &nbsp; Edit Profile Information';
    }
  }
}
