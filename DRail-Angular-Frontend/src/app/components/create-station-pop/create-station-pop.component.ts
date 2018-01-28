import { Component, OnInit } from '@angular/core';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { DialogComponent } from 'ng2-bootstrap-modal/dist/dialog.component';
import { ConfirmModel } from '../tilepop/tilepop.component';
import { Station } from '../../models/station';

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
  constructor(dialogService: DialogService) {
    super(dialogService);
 }



}
