import { Component, OnInit } from '@angular/core';
import { Station } from '../../models/station';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements OnInit {

  stationDetails: Station = new Station(268, 'Station Name', null, null, [126, 127, 128], null);

  constructor() { }

  ngOnInit() {
  }

}
