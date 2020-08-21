import { Component, OnInit } from '@angular/core';
import { ProfileComponent } from '../profile.component';
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
  selector: 'app-info-edit',
  templateUrl: './info-edit.component.html',
  styleUrls: ['./info-edit.component.css']
})
export class InfoEditComponent extends ProfileComponent {

  form: FormGroup;

  statusMessage: string;

  constructor(formBuilder: FormBuilder, userService: UserService, profileService: ProfileService) {
    super(userService, profileService);

    this.form = formBuilder.group ({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.compose([Validators.required, Validators.email])]
    });
  }

  saveProfileInformation() {
    this.statusMessage = '';

    const updatedUser = this.currentUser;
    updatedUser.firstname = this.firstname;
    updatedUser.lastname = this.lastname;
    updatedUser.email = this.email;

    this.profileService.updateUser(updatedUser).subscribe(
      response => {
        this.userService.setUser(updatedUser);
        if (response.status === 200) {
          this.statusMessage = 'Profile updated successfully!';
          document.getElementById('profileStatus').setAttribute('style', 'color:green;');
        } else {
          this.statusMessage = 'There was an error processing your request';
          document.getElementById('profileStatus').setAttribute('style', 'color:red;');
        }
      }
    );
  }

}
