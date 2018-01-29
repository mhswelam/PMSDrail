import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Station } from '../../models/station';
import { Rail } from '../../models/rail';
import { StationService } from '../../services/station.service';
import { DragulaService } from 'ng2-dragula/components/dragula.provider';
import { UtilsService } from '../../services/utils.service';
import { DialogService, DialogComponent } from 'ng2-bootstrap-modal';
import { AddRailComponent } from '../add-rail/add-rail.component';
import { Subject } from 'rxjs/Subject';
import { ApplicationRef } from '@angular/core';

@Component({
  selector: 'app-station',
  templateUrl: './station.component.html',
  styleUrls: ['./station.component.css']
})


export class StationComponent implements OnInit {

  public static refreshStation: Subject<boolean> = new Subject();

  station: Station;
  rails: Rail[] = [];

  constructor(
    private stationService: StationService,
    private route: ActivatedRoute,
    private dragula: DragulaService,
    private utilsService: UtilsService,
    private dialogService: DialogService,
    private appRef: ApplicationRef) {
    StationComponent.refreshStation.subscribe(
      res => {
        console.log('Refreshing...');
        this.getStation();
        this.getRails();
      }
    );
  }

  ngOnInit() {
    this.getStation();
    this.getRails();

    this.dragula.drop.subscribe(
      val => {
        this.station.railIds = this.utilsService.map(this.rails, e => e.railId);
        this.stationService.saveRailOrder(this.station);
      }
    );
  }

  getStation() {
    this.station = this.stationService.selected();
  }

  getRails() {
    if (this.station != null) {
      this.stationService.getRails(this.station)
        .subscribe(
        response => {
          this.rails = response;
          if (!this.rails) {
            this.rails = [];
          }
        },
        err => this.handleError(err)
        );
    }
  }

  handleError(err) {
    console.log(err);
  }

  showAddRail() {
    const disposable = this.dialogService.addDialog(AddRailComponent, { station: this.station}).subscribe(
      // this.stationService.refresh()
    );
  }

}
