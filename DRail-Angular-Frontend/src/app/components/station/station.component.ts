import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


import { Station } from '../../models/station';
import { Rail } from '../../models/rail';
import { StationService } from '../../services/station.service';
import { DragulaService } from 'ng2-dragula/components/dragula.provider';
import { UtilsService } from '../../services/utils.service';

@Component({
  selector: 'app-station',
  templateUrl: './station.component.html',
  styleUrls: ['./station.component.css']
})
export class StationComponent implements OnInit {

  station: Station; // = new Station(268, 'Station Name', null, null, [126, 127, 128], null);
  rails: Rail[];

  constructor(
    private stationService: StationService,
    private route: ActivatedRoute,
    private dragula: DragulaService,
    private utilsService: UtilsService) { }

  ngOnInit() {
   this.getStation();
   this.getRails();

   this.dragula.drop.subscribe(
    val => {
      console.log(val);
      console.log(this.station.railIds);
      console.log(this.rails);
      this.station.railIds = this.utilsService.map(this.rails, e => e.railId);
      console.log(this.station.railIds);
      this.stationService.saveRailOrder(this.station);
    }
  );
  }

  getStation() {
    this.stationService.select(new Station(268, 'Test Station Name', null, null, [126, 127, 128], null));
    this.station = this.stationService.selected();
  }

  getRails () {
    if (this.station != null) {
      this.stationService.getRails(this.station)
      .subscribe(
        response => {
          this.rails = response;
        },
        err => this.handleError(err)
      );
    }
  }

  handleError (err) {
    console.log(err);
  }



}
