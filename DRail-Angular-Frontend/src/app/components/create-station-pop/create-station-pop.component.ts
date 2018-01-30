import { Component, OnInit } from '@angular/core';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { DialogComponent } from 'ng2-bootstrap-modal/dist/dialog.component';
import { ConfirmModel } from '../tilepop/tilepop.component';
import { Station } from '../../models/station';
import { Data } from '@angular/router/src/config';
import { CreateStationService } from '../../services/create-station.service';
import { Router } from '@angular/router';
import { window } from 'rxjs/operator/window';
import { UserService } from '../../services/user.service';
import { Role } from '../../models/role';

export interface CreateStationModel {

  stationObj: Station;

}


@Component({
  selector: 'app-create-station-pop',
  templateUrl: './create-station-pop.component.html',
  styleUrls: ['./create-station-pop.component.css']
})
// DialogComponent<ConfirmModel, boolean> implements ConfirmModel
export class CreateStationPopComponent extends DialogComponent<CreateStationModel, boolean> implements CreateStationModel {

  stationObj: Station;
  public name: string;
  public dueDate: number;
  constructor(dialogService: DialogService, private createStationService: CreateStationService, private route: Router,
     private userService: UserService) {
    super(dialogService);
  }

  confirm() {
    // we set dialog result as true on click on confirm button,
    // then we can get dialog result from caller code
    this.close();
  }
  createStation() {
    let station: Station = new Station( null, this.name, null, this.dueDate, null, null);
    console.log(station.name);
    console.log(station.dueDate);

    if (typeof station.name !== 'undefined' && typeof station.dueDate !== 'undefined') {
       this.createStationService.createStation(station).subscribe(
         resp => {
           // this.userService.refreshUser();
           // userService.getUser().stationRoleMap.put(response.stationid, 64)
           this.userService.getUser().stationRoleMap[resp.stationId] = new Role(64, 'PRODUCT OWNER');
           this.close();
       });
   }

  }

}
