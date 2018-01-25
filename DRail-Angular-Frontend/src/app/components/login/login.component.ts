import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators} from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginLabel = 'Login To Drail';
  rForm: FormGroup;
  post: any;
  alert = 'Please Enter username';
  fPassword = '';
  username = '';

  constructor(private fb: FormBuilder) {

    this.rForm = fb.group({
      'username':  [null, Validators.compose([Validators.required, Validators.minLength(4), Validators.maxLength(15)])],
      'fPassword': [null, Validators.compose([Validators.required])]
    });

  }

  ngOnChanges() {
     if (this.rForm.get('username').value() < 4) {
      this.alert = 'Username Must Be Atleast 3 Characters or More';
    }
  }

  ngOnInit(){
  }

  addPost(post) {
    this.username = post.username;
    this.fPassword = post.fPassword;
  }

}
