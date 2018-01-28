import { Component, OnInit, Input } from '@angular/core';
import { GetStationsService } from '../../services/get-stations.service';
import { Station } from '../../models/station';
import { StationService } from '../../services/station.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-station-view',
  templateUrl: './station-view.component.html',
  styleUrls: ['./station-view.component.css']
})
export class StationViewComponent implements OnInit {

 @Input() station: Station;
  constructor(private Service: StationService, private router: Router) {

   }

  ngOnInit() {
  }

  loadStation(station) {
    this.Service.getStation(station).subscribe(
      response => {this.Service.select(response);
      this.router.navigate(['station/test']); });
  }

}
