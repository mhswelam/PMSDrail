import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators} from '@angular/forms';
import { FormControl } from '@angular/forms/src/model';
import {User} from '../../models/user';
import {RegisterService} from '../../services/register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerLabel = 'Register With Drail';
  loginLabel = 'Existing User';
  rForm: FormGroup;
  post: any;
  failedRegister;
  failedRegisterHeader;
  failedRegisterMessage;
  username;
  fPassword;
  cpassword;
  fname;
  lname;
  email;
  usernameAlert;
  passAlert;
  fnameAlert;
  lnameAlert;
  emailAlert;

  constructor(private fb: FormBuilder, private registerService: RegisterService, private router: Router) {

    const emailValidation = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/;

    this.rForm = fb.group(
      {
        'username':  [null, Validators.compose([Validators.required, Validators.minLength(4), Validators.maxLength(15)])],
        'fPassword':  [null,
        Validators.compose([
        Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&~])[A-Za-z0-9$@$!%*?&]{8,}'),
        Validators.required])],
        'cpassword': [null, Validators.compose([Validators.required])],
        'fname': [null,
        Validators.compose([Validators.pattern('^[a-zA-Z_-]+$'), Validators.required, Validators.minLength(3)])],
        'lname': [null,
        Validators.compose([Validators.pattern('^[a-zA-Z_-]+$'), Validators.required, Validators.minLength(3)])],
        'email': [null,
          Validators.compose([Validators.required, Validators.pattern(emailValidation)])]
      }
    );
  }

  ngOnInit() {
  this.username = '';
  this.fPassword = '';
  this.cpassword = '';
  this.fname = '';
  this.lname = '';
  this.email = '';
  this.failedRegister = false;
  }

  checkLength() {
    const username = this.rForm.get('username');
    if (username.value.length === 0) {
      this.usernameAlert = 'Username Must Be Entered';
    } else if (username.value.length < 4) {
      this.usernameAlert = 'Username Must Greater Than Four Characters';
  }else if (username.value.length > 15) {
      this.usernameAlert = 'Username Cannot be more then 15 Charactrs Long';
    } else if (username.dirty) {
      this.usernameAlert = 'Username Must NOT Contain Special Characters';
    }
  }

  checkPass() {
    const password = this.rForm.get('fPassword');
    if (password.value.length === 0) {
      this.passAlert = 'Please enter password';
    } else if (password.value.length < 8) {
      this.passAlert = 'Password Must be Greater then 8 Characters';
      }else if (password.dirty) {
       this.passAlert = 'Password Must Contain One Number/One Letter/One Special Character($@$!%*?&~)';
      }
    }

  setConfirmPass() {
    if (this.fPassword !== this.rForm.get('cpassword').value) {
    this.rForm.get('cpassword').reset();
    }
    this.rForm.get('cpassword').setValidators([Validators.pattern(this.fPassword), Validators.required]);
  }

  checkFName() {
    const fname = this.rForm.get('fname');
    if (fname.value.length === 0) {
      this.fnameAlert = 'First Name Required';
    }else if (fname.value.length < 3) {
      this.fnameAlert = 'First Name Must Be Greater Than 3 Characters';
    }else if (fname.dirty) {
      this.fnameAlert = 'First can NOT have any special character or spaces ';
    }
  }

  checkLName() {
    const lname = this.rForm.get('lname');
    if (lname.value.length === 0) {
      this.lnameAlert = 'Last Name Required';
    }else if (lname.value.length < 3) {
      this.lnameAlert = 'Last Name Must Be Greater Than 3 Characters';
    }else if (lname.dirty) {
      this.lnameAlert = 'Last can NOT have any special character or spaces ';
    }
  }

    checkEmail() {
      const email = this.rForm.get('email');
      if (email.value.length === 0) {
        this.emailAlert = 'Email Required';
      }else if (email.dirty) {
         this.emailAlert = 'Email Must Be In The Format Of (Example@email.com)';
      }
  }

  addPost(post) {
    this.username = post.username;
    this.fPassword = post.fPassword;
    this.fname = post.fname;
    this.lname = post.lname;
    this.email = post.email;

    const user = new User(null, this.username, this.fPassword, this.fname, this.lname, this.email, null);

    this.registerService.registerUser(user).subscribe(
      response => {
          this.registerService.setRegisterSucessful(true);
          this.router.navigate(['login']);
      }, error => {
        if (error.status === 0) {
          this.failedRegister = true;
          this.failedRegisterHeader = 'FAILED CONNECTION';
          this.failedRegisterMessage = 'We apologize but something went wrong on our side';
        }else {
          this.failedRegister = true;
          this.failedRegisterMessage = 'USERNAME ALREADY EXIST';
          this.failedRegisterMessage = 'Please choose a more unique name';
        }
      }
    );
  }

  setFailedRegisterFalse() {
    this.failedRegister = false;
  }

  redirectToLogin() {
    this.registerService.setRegisterSucessful(false);
    this.router.navigate(['login']);
  }


  }


