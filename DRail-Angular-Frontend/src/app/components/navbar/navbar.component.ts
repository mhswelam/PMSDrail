import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { LogoutService } from '../../services/logout.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private username: String;

  constructor(private userService: UserService, private logoutSer: LogoutService, private router: Router) {
  }

  ngOnInit() {
     this.username = this.userService.getUser().username;
  }

  sendlogout() {
    this.logoutSer.logout().subscribe(res => {
        console.log(res.status);
        this.userService.setUser(null);
        this.router.navigate(['']);
      });
    }
}
