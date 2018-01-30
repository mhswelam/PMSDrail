import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { DialogComponent } from 'ng2-bootstrap-modal/dist/dialog.component';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';

export interface CreateUserModel {
  user: User;
}

@Component({
  selector: 'app-add-user-pop',
  templateUrl: './add-user-pop.component.html',
  styleUrls: ['./add-user-pop.component.css']
})
export class AddUserPopComponent extends DialogComponent<CreateUserModel, boolean> implements CreateUserModel {
  user: User;
  constructor(dialogService: DialogService) {
    super(dialogService);
   }


}
