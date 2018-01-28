import { Component, OnInit } from '@angular/core';
import { DialogService } from 'ng2-bootstrap-modal/dist/dialog.service';
import { CreateStationPopComponent } from '../create-station-pop/create-station-pop.component';

@Component({
  selector: 'app-add-station',
  templateUrl: './add-station.component.html',
  styleUrls: ['./add-station.component.css']
})
export class AddStationComponent implements OnInit {

  constructor(private dialogService: DialogService) { }

  ngOnInit() {
  }

  createStation() {
    console.log('in here');
    this.dialogService.addDialog(CreateStationPopComponent).subscribe();
  }
}
