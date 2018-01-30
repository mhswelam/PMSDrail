import { ProfileComponent } from '../profile.component';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { ProfileService } from '../../../services/profile.service';
import { FormGroup } from '@angular/forms/src/model';
import { ValidatorFn,
         Validators,
         AbstractControl,
         FormControl,
         NG_VALIDATORS,
         FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-info-password',
  templateUrl: './info-password.component.html',
  styleUrls: ['./info-password.component.css']
})
export class InfoPasswordComponent  extends ProfileComponent {

  form: FormGroup;

  statusMessage: string;

  password: string;
  cPassword: string;

  constructor(formBuilder: FormBuilder, userService: UserService, profileService: ProfileService) {
    super(userService, profileService);

    this.form = formBuilder.group ({
      password: ['', Validators.required],
      cPassword: ['', [Validators.required, Validators.pattern(this.password)]]
    });
  }

  saveNewPassword() {
    this.statusMessage = '';

    const updatedUser = this.currentUser;
    updatedUser.password = this.password;


    this.profileService.updateUser(updatedUser).subscribe(
      response => {
        this.userService.setUser(updatedUser);
        if (response.status === 200) {
          this.statusMessage = 'Password Updated!';
          document.getElementById('profileStatus').setAttribute('style', 'color:green;');
        } else {
          this.statusMessage = 'Password Updated!';
          document.getElementById('profileStatus').setAttribute('style', 'color:red;');
        }
      }
    );
  }

}
