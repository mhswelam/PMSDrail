import { Component, OnInit } from '@angular/core';
import { ProfileComponent } from '../profile.component';
import { UserService } from '../../../services/user.service';
import { ProfileService } from '../../../services/profile.service';

@Component({
  selector: 'app-info-edit',
  templateUrl: './info-edit.component.html',
  styleUrls: ['./info-edit.component.css']
})
export class InfoEditComponent extends ProfileComponent {

  saveProfileInformation() {

    const updatedUser = this.currentUser;
    updatedUser.firstname = this.firstname;
    updatedUser.lastname = this.lastname;
    updatedUser.email = this.email;

    this.profileService.updateUser(updatedUser).subscribe(
      response => {
        this.userService.setUser(updatedUser);
      }/*,
      param => { function() body },
       error => */
    );

    super.changeDisplay();
  }

}
