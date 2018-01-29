import { Component, OnInit } from '@angular/core';
import { GetStationsService } from '../../services/get-stations.service';
import { Station } from '../../models/station';
import { Input } from '@angular/core/src/metadata/directives';
import { Stations } from '../../models/stations';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-stations',
  templateUrl: './stations.component.html',
  styleUrls: ['./stations.component.css']
})
export class StationsComponent implements OnInit {

  user: User;
  stations: Station[];
  constructor(private getStationsService: GetStationsService, private userService: UserService) { }

  ngOnInit() {
    this.getStationInfo();
    this.getUserInfo();
  }

  getStationInfo() {
    /*this.getStationsService.getStations().subscribe(response => {console.log(response);
      this.stations = response; });*/
      this.getStationsService.getStations().subscribe(data => {this.stations = data.stations;
          console.log(data); });
  }

  getUserInfo() {
    this.user = this.userService.getUser();
  }
}
