import { Component, OnInit } from '@angular/core';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { CreateStationPopComponent } from '../create-station-pop/create-station-pop.component';
import { CreateStationService } from '../../services/create-station.service';

@Component({
  selector: 'app-add-station',
  templateUrl: './add-station.component.html',
  styleUrls: ['./add-station.component.css']
})
export class AddStationComponent implements OnInit {

  constructor(private dialogService: DialogService, private createStationService: CreateStationService) { }

  ngOnInit() {
  }

  createStation() {
    console.log('in here');
    this.dialogService.addDialog(CreateStationPopComponent).subscribe(reps => this.createStationService.refresh());
  }
}
