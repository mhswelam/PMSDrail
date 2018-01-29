import { Component, OnInit } from '@angular/core';
import { DialogComponent, DialogService } from 'ng2-bootstrap-modal';
import { Station } from '../../models/station';
import { ChartService } from '../../services/chart.service';
import { ChartIn } from '../../models/chartin';
import { ChartOut } from '../../models/chartout';
import { StationService } from '../../services/station.service';


export interface ChartModel  {

  currentSt: Station;

}


@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})



export class ChartComponent extends DialogComponent<ChartModel, boolean> implements ChartModel , OnInit {

  currentSt: Station;
  currentChart: ChartIn;
  chartout: ChartOut = new ChartOut(null, 0);


  constructor(dialogService: DialogService, private chartSer: ChartService) {
    super(dialogService);

   }

   ngOnInit() {
    this.chartout.stId = this.currentSt.stationId;
    this.chartSer.getChart(this.chartout).subscribe(
      data => {this.currentChart = data; console.log(this.currentChart); });
   }

   confirm() {
    this.result = true;
    this.close();
  }




}
