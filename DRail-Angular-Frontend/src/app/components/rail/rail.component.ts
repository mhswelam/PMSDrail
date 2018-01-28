import { Component, OnInit, Input } from '@angular/core';
import { Rail } from '../../models/rail';
import { Tile } from '../../models/tile';
import { RailService } from '../../services/rail.service';
import { DragulaService } from 'ng2-dragula/ng2-dragula';
import { UserService } from '../../services/user.service';
import { UtilsService } from '../../services/utils.service';


@Component({
  selector: 'app-rail',
  templateUrl: './rail.component.html',
  styleUrls: ['./rail.component.css']
})
export class RailComponent implements OnInit {

  @Input() rail: Rail;
  tiles: Tile[] = [];

  constructor(
    private railService: RailService,
    private dragula: DragulaService,
    private userService: UserService,
    private utilsService: UtilsService) { }

  ngOnInit() {
    this.getTiles();

    this.dragula.drop.subscribe(
      val => {
        this.rail.tileIds = this.utilsService.map(this.tiles, e => e.tileId);
        this.railService.saveTileOrder([this.rail]);
      }
    );


  }

  getTiles() {
    this.railService.getTiles(this.rail).subscribe(
      (data => {
        this.tiles = data;
        if (!this.tiles) {
          this.tiles = [];
        }

      }),
      err => console.log(err)
    );

  }

  showTiles() {
    for (let tile of this.tiles) {
      console.log(tile);
    }
  }

}