import { Component, OnInit } from '@angular/core';
import { Station } from '../../models/station';
import { Rail } from '../../models/rail';
import { DialogComponent } from 'ng2-bootstrap-modal';
import { dialogServiceFactory } from 'ng2-bootstrap-modal/dist/bootstrap-modal.module';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { RailService } from '../../services/rail.service';

export interface UpdateRailModal {
  rail: Rail;
}

@Component({
  selector: 'app-update-rail',
  templateUrl: './update-rail.component.html',
  styleUrls: ['./update-rail.component.css']
})
export class UpdateRailComponent extends DialogComponent<UpdateRailModal, boolean> implements UpdateRailModal, OnInit {

  name = '';
  rail: Rail;

  constructor(dialogService: DialogService, private railService: RailService) {
    super(dialogService);
   }

  ngOnInit() {
  }

  updateRail() {
    this.rail.name = this.name;
    this.railService.updateRail(this.rail).subscribe(resp => this.confirm());
  }

  confirm() {
    // we set dialog result as true on click on confirm button,
    // then we can get dialog result from caller code
    this.result = true;
    this.close();
    // this.stationService.refresh();
  }

}

