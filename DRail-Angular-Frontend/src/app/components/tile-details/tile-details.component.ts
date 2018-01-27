import { Component, OnInit, Input } from '@angular/core';
import { Tile } from '../../models/tile';

@Component({
  selector: 'app-tile-details',
  templateUrl: './tile-details.component.html',
  styleUrls: ['./tile-details.component.css']
})
export class TileDetailsComponent implements OnInit {

  @Input() tile: Tile;

  constructor() { }

  ngOnInit() {
  }

}
