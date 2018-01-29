import { Component, OnInit, Input } from '@angular/core';
import { Rail } from '../../models/rail';
import { Tile } from '../../models/tile';
import { RailService } from '../../services/rail.service';
import { DragulaService } from 'ng2-dragula/ng2-dragula';
import { UserService } from '../../services/user.service';
import { UtilsService } from '../../services/utils.service';
import { UpdateRailComponent } from '../update-rail/update-rail.component';
import { StationService } from '../../services/station.service';
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
  rails: Rail[] = [];

  /* Adding Tiles */
  roleId: number;
  tileTitle: string;
  tilePoints: number;
  tileNote: string;

  constructor(
    private railService: RailService,
    private dragula: DragulaService,
    private userService: UserService,
    private tileService: TileService,
    private utilsService: UtilsService,
    private dialogService: DialogService,
    private stationService: StationService) { }

  ngOnInit() {
    this.getTiles();
    this.roleId = this.userService.getUser().stationRoleMap[this.stationService.selected().stationId].id;

    this.dragula.drop.subscribe(
      val => {
        this.rail.tileIds = this.utilsService.map(this.tiles, e => e.tileId);
        this.railService.saveTileOrder([this.rail]);
      }
    );


  }

  createTileDialog() {
    let disposable = this.dialogService.addDialog(AddtilepopComponent, {
        railObj: this.rail
    }).subscribe();
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

  showUpdateRail() {
    const disposable = this.dialogService.addDialog(UpdateRailComponent, { rail: this.rail}).subscribe();
  }

}
