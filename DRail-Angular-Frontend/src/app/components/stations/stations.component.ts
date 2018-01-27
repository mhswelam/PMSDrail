import { Component, OnInit } from '@angular/core';
import { GetStationsService } from '../../services/get-stations.service';
import { Station } from '../../models/station';
import { Input } from '@angular/core/src/metadata/directives';
import { Stations } from '../../models/stations';

@Component({
  selector: 'app-stations',
  templateUrl: './stations.component.html',
  styleUrls: ['./stations.component.css']
})
export class StationsComponent implements OnInit {

  stations: Station[];
  constructor(private getStationsService: GetStationsService) { }

  ngOnInit() {
    this.getStationInfo();
  }

  getStationInfo() {
    /*this.getStationsService.getStations().subscribe(response => {console.log(response);
      this.stations = response; });*/
      this.getStationsService.getStations().subscribe(data => {this.stations = data.stations;
          console.log(data); });
  }
}
