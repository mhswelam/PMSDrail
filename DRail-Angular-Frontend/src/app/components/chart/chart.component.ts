import { Component, OnInit } from '@angular/core';
import { DialogComponent, DialogService } from 'ng2-bootstrap-modal';
import { Station } from '../../models/station';
import { ChartService } from '../../services/chart.service';
import { ChartIn } from '../../models/chartin';
import { ChartOut } from '../../models/chartout';
import { StationService } from '../../services/station.service';


export interface ChartModel  {

  currentChart: ChartIn;

}


@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})



export class ChartComponent extends DialogComponent<ChartModel, boolean> implements ChartModel , OnInit {

  currentChart: ChartIn = new ChartIn([], []);


  constructor(dialogService: DialogService, private chartSer: ChartService) {
    super(dialogService);

   }

 // lineChart
 public lineChartData: Array<any>;
 public lineChartLabels: Array<any>;
 public lineChartOptions: any = {
  responsive: true
};
public lineChartColors: Array<any> = [

  { // dark grey
    backgroundColor: 'rgba(77,83,96,0.2)',
    borderColor: 'rgba(30, 5, 121, 0.2)',
    pointBackgroundColor: 'rgba(138, 8, 127, 0.2)',
    pointBorderColor: 'rgb(221, 19, 19)',
    pointHoverBackgroundColor: '#fff',
    pointHoverBorderColor: 'rgba(77,83,96,1)'
  }
];
public lineChartLegend: boolean = true;
public lineChartType: string = 'line';


ngOnInit() {

  this.lineChartData = [
    {data: [this.currentChart.points].concat(this.currentChart.data), label: 'Project Points'}
  ];

  this.lineChartLabels = [0].concat(this.currentChart.labels);
 }
// events
public chartClicked(e: any): void {
  console.log(e);
}

public chartHovered(e: any): void {
  console.log(e);
}

confirm() {
  this.result = true;
  this.close();
}

}
