import { Component, OnInit } from '@angular/core';
import { Station } from '../../models/station';
import { Rail } from '../../models/rail';
import { StationService } from '../../services/station.service';
import { RailService } from '../../services/rail.service';
import { DialogService, DialogComponent } from 'ng2-bootstrap-modal';
import {Router} from '@angular/router';


export interface AddRailModal {
  station: Station;
}

@Component({
  selector: 'app-add-rail',
  templateUrl: './add-rail.component.html',
  styleUrls: ['./add-rail.component.css']
})
export class AddRailComponent extends DialogComponent<AddRailModal, boolean> implements AddRailModal, OnInit {

  name = '';
  station: Station;

  constructor(private railService: RailService, private stationService: StationService, dialogService: DialogService,
     private router: Router) {
    super(dialogService);
  }

  ngOnInit() {
  }

  addRail() {
    const stationId = this.station.stationId;
    const order = this.station.railIds.length;
    const rail = new Rail(0, this.name, order, stationId, []);
    this.railService.createRail(rail).subscribe(resp => this.confirm());
  }

  confirm() {
    // we set dialog result as true on click on confirm button,
    // then we can get dialog result from caller code
    this.result = true;
    this.close();
    this.stationService.refresh();
  }

}
