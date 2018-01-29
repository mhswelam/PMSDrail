import { Component, OnInit } from '@angular/core';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { DialogComponent } from 'ng2-bootstrap-modal/dist/dialog.component';
import { ConfirmModel } from '../tilepop/tilepop.component';
import { Station } from '../../models/station';
import { Data } from '@angular/router/src/config';
import { CreateStationService } from '../../services/create-station.service';
import { Router } from '@angular/router';
import { window } from 'rxjs/operator/window';

export interface CreateStationModel  {

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
  constructor(dialogService: DialogService, private createStationService: CreateStationService, private route: Router) {
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
  this.createStationService.createStation(station).subscribe(resp => this.close());
  // this.route.navigate(['/stations?refresh=1']);
 // this.stationObj.name = this.name;
 // this.stationObj.dueDate = this.dueDate;
  // console.log(this.stationObj);
 }



}
