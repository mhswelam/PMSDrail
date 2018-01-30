import { Component, OnInit, Input } from '@angular/core';
import { DialogComponent } from 'ng2-bootstrap-modal/dist/dialog.component';
import { Station } from '../../models/station';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { Router } from '@angular/router';
import { StationViewComponent } from '../station-view/station-view.component';
import { StationService } from '../../services/station.service';

export interface EditStationModel  {

  stationObj: Station;

}

@Component({
  selector: 'app-edit-station-pop',
  templateUrl: './edit-station-pop.component.html',
  styleUrls: ['./edit-station-pop.component.css']
})
export class EditStationPopComponent extends DialogComponent<EditStationModel, boolean> implements EditStationModel, OnInit {

  stationObj: Station;
  public name: string;
  public dueDate: number;
  constructor(dialogService: DialogService, private router: Router, private stationService: StationService) {
    super(dialogService);
  }
  ngOnInit() {
    this.name = this.stationObj.name;
    this.dueDate = this.stationObj.dueDate;
    console.log(this.dueDate);
  }

  confirm() {
    // we set dialog result as true on click on confirm button,
    // then we can get dialog result from caller code
    this.close();
  }

  updateStation() {
    console.log(this.name);
    console.log(this.dueDate);
    this.stationObj.name = this.name;
    this.stationObj.dueDate = this.dueDate;
    console.log(this.stationObj.stationId);
    // if(this.name == this.stationObj.name &&)
    this.stationService.updateStation(this.stationObj).subscribe(resp => this.confirm());
  }
}
