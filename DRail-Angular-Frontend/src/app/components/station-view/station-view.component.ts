import { Component, OnInit, Input } from '@angular/core';
import { GetStationsService } from '../../services/get-stations.service';
import { Station } from '../../models/station';
import { StationService } from '../../services/station.service';
import {Router} from '@angular/router';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { EditStationPopComponent } from '../edit-station-pop/edit-station-pop.component';
import { CreateStationPopComponent } from '../create-station-pop/create-station-pop.component';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-station-view',
  templateUrl: './station-view.component.html',
  styleUrls: ['./station-view.component.css']
})
export class StationViewComponent implements OnInit {


 @Input() station: Station;
  constructor(private Service: StationService, private router: Router, private dialogService: DialogService) {

   }

  ngOnInit() {
  }

  loadStation(station) {
    this.Service.getStation(station).subscribe(
      response => {this.Service.select(response);
      this.router.navigate(['station']); });
  }

  updateStation(station) {
    console.log('update info');
    console.log('in here');
    //
    this.dialogService.addDialog(EditStationPopComponent, {stationObj : this.station});
  }
}
