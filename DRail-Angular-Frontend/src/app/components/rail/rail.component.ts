import { Component, OnInit, Input } from '@angular/core';
import { Rail } from '../../models/rail';
import { Tile } from '../../models/tile';
import { RailService } from '../../services/rail.service';
import { DragulaService } from 'ng2-dragula/ng2-dragula';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-rail',
  templateUrl: './rail.component.html',
  styleUrls: ['./rail.component.css']
})
export class RailComponent implements OnInit {

  @Input() rail: Rail;
  tiles: Tile[] = [];

  constructor(private railService: RailService, private dragula: DragulaService, private userService: UserService) { }

  ngOnInit() {
    this.getTiles();

    this.dragula.drop.subscribe(
      val => {
        console.log("ids before swap " + this.rail.tileIds);
        console.log('An item has been dropped.');
        this.rail.tileIds = this.map(this.tiles, e => e.tileId);
        console.log('ids after swap ' + this.rail.tileIds);
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

  map(lst, fun) {
    let result = [];
    for (let elem of lst) {
      result.push(fun(elem));
    }
    return result;
  }



}
