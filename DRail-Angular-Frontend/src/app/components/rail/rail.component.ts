import {Tile} from '../../models/tile';
import { Component, OnInit, Input } from '@angular/core';
import { Rail } from '../../models/rail';
import { RailService } from '../../services/rail.service';
import { DragulaService } from 'ng2-dragula/ng2-dragula';
import { UserService } from '../../services/user.service';
import { FormGroup } from '@angular/forms/src/model';

import { TileService } from '../../services/tile.service';
import { AddtilepopComponent } from '../addtilepop/addtilepop.component';
import { DialogComponent, DialogService } from 'ng2-bootstrap-modal';


@Component({
  selector: 'app-rail',
  templateUrl: './rail.component.html',
  styleUrls: ['./rail.component.css']
})
export class RailComponent implements OnInit {

  @Input() rail: Rail;
  tiles: Tile[] = [];

  /* Adding Tiles */
  roleId: number;
  tileTitle: string;
  tilePoints: number;
  tileNote: string;
  statusMessage: string;

  constructor(private railService: RailService, private dragula: DragulaService,
    private userService: UserService, private tileService: TileService, private dialogService: DialogService) {
     }

  ngOnInit() {
    this.getTiles();

    this.dragula.drop.subscribe(
      val => {
        console.log('ids before swap ' + this.rail.tileIds);
        console.log('An item has been dropped.');
        this.rail.tileIds = this.map(this.tiles, e => e.tileId);
        console.log('ids after swap ' + this.rail.tileIds);
        this.railService.saveTileOrder([this.rail]);
      }
    );

    this.roleId = this.userService.getUsersRole().id;
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

  createTileDialog() {
    this.showCreate(this.rail);
  }

  showCreate(inRail: Rail) {
    let disposable = this.dialogService.addDialog(AddtilepopComponent, {
      railObj: inRail
    }).subscribe();
  }

}
