import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  isEditing = false;

  firstname = 'Firstname';
  lastname = 'Lastname';
  username = 'Username';
  email = 'Email';

  constructor() { }

  ngOnInit() {
  }

  changeDisplay() {
    this.isEditing = !this.isEditing;
  }
}
