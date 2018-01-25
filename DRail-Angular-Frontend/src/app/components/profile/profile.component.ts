import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  firstname = 'Firstname';
  lastname = 'Lastname';
  username = 'Username';
  email = 'Email';

  constructor() { }

  ngOnInit() {
  }

}
