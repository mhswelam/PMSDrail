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
  passAlert;

  constructor(formBuilder: FormBuilder, userService: UserService, profileService: ProfileService) {
    super(userService, profileService);

    this.form = formBuilder.group ({
      'password':  [null,
        Validators.compose([
        Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&~])[A-Za-z0-9$@$!%*?&]{8,}'),
        Validators.required])],
        'cPassword': [null, Validators.compose([Validators.required])]
    });
  }

  checkPass() {
    const password = this.form.get('password');
    if (password.value.length === 0) {
      this.passAlert = 'Please enter password';
    } else if (password.value.length < 8) {
      this.passAlert = 'Password Must be Greater then 8 Characters';
      }else if (password.dirty) {
       this.passAlert = 'Password Must Contain One Number/One Letter/One Special Character($@$!%*?&~)';
      }
    }

  setConfirmPass() {
    if (this.password !== this.form.get('cPassword').value) {
    this.form.get('cPassword').reset();
    }
    this.form.get('cPassword').setValidators([Validators.pattern(this.password), Validators.required]);
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
