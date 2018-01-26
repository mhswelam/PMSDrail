import { Component, OnInit, Input } from '@angular/core';
import { Rail } from '../../models/rail';
import { Tile } from '../../models/tile';
import { RailService } from '../../services/rail.service';

@Component({
  selector: 'app-rail',
  templateUrl: './rail.component.html',
  styleUrls: ['./rail.component.css']
})
export class RailComponent implements OnInit {

  @Input() rail: Rail;
  tiles: Tile[];

  constructor(private railService: RailService) { }

  ngOnInit() {
    this.getTiles();
  }

  getTiles() {
    this.railService.getTiles(this.rail).subscribe(
      data => this.tiles = data,
      err => console.log(err));
  }



}
