import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { DialogComponent } from 'ng2-bootstrap-modal/dist/dialog.component';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { StationService } from '../../services/station.service';
import { Station } from '../../models/station';
import { Role } from '../../models/role';

export interface CreateUserModel {
  user: User;
  stationObj: Station;
}

@Component({
  selector: 'app-add-user-pop',
  templateUrl: './add-user-pop.component.html',
  styleUrls: ['./add-user-pop.component.css']
})
export class AddUserPopComponent extends DialogComponent<CreateUserModel, boolean> implements CreateUserModel {
  user: User;
  name: string;
  stationObj: Station;
  constructor(dialogService: DialogService, private stationService: StationService) {
    super(dialogService);
  }

  confirm() {
    // we set dialog result as true on click on confirm button,
    // then we can get dialog result from caller code
    this.close();
  }
  addUser() {
    this.stationService.getUser(this.name).subscribe(resp => {
      this.user = resp;
      console.log(this.user);
      this.stationObj.userRoleMap[this.user.userId] = new Role(652, 'TEAM MEMEBR');
      this.stationService.updateStation(this.stationObj).subscribe(re => this.confirm());
    });
  }
}
