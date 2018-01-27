import {User} from '../../models/user';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators} from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { Response } from '@angular/http/src/static_response';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginLabel = 'Login To Drail';
  failedLogin;
  rForm: FormGroup;
  post: any;
  alert = 'Please Enter username';
  fPassword;
  username;

  constructor(private fb: FormBuilder, private loginService: LoginService, private userService: UserService, private router: Router) {

    this.rForm = fb.group({
      'username':  [null, Validators.compose([Validators.required, Validators.minLength(4), Validators.maxLength(15)])],
      'fPassword': [null, Validators.compose([Validators.required])]
    });

  }

  // OnChanges() {
  //   this.rForm.get('username').valueChanges.subscribe(
  //     (username) => { if (this.username.length === 0) {
  //       this.alert = 'Username Must Be Entered';
  //     } else if (this.username.length < 4) {
  //       this.alert = 'Username Must Greater Than Four Characters';
  //     }
  //   }
  //   );
  // }

  ngOnInit() {
    this.failedLogin = false;
    this.fPassword = '';
    this.username = '';
  }


  addPost(post) {
    this.username = post.username;
    this.fPassword = post.fPassword;

    const user = new User(0, this.username, this.fPassword, '', '', '', null);
    this.loginService.validateUser(user).subscribe(
      response => {
      this.router.navigate(['stations']);
       this.userService.setUser(response); }
       , err => {
         console.log(err.status);
         this.userService.setUser(null);
         this.username = '';
         this.fPassword = '';
         this.failedLogin = true; }
      );
  }

  checkLength() {
    const username = this.rForm.get('username');
    if (username.value.length === 0) {
      this.alert = 'Username Must Be Entered';
    } else if (username.value.length < 4) {
      this.alert = 'Username Must Greater Than Four Characters';
  }else if (username.value.length > 15) {
      this.alert = 'Username Cannot be more then 15 Charactrs Long';
    } else if (username.dirty) {
      this.alert = 'Username Must NOT Contain Special Characters';
    }
}

setFailedLoginFalse() {
  this.failedLogin = false;
}

}
