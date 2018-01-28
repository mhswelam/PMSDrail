import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Tile } from '../../models/tile';
import { TileService } from '../../services/tile.service';
import { Task } from '../../models/task';
import { DialogService } from 'ng2-bootstrap-modal';
import { TilepopComponent } from '../tilepop/tilepop.component';

@Component({
  selector: 'app-tile-details',
  templateUrl: './tile-details.component.html',
  styleUrls: ['./tile-details.component.css']
})
export class TileDetailsComponent implements OnInit {

  @Input() tile: Tile;
  private tileObj: Tile;


  constructor(private tileSer: TileService, private dialogService: DialogService) { }

  ngOnInit() {
  }

  getTileInfo() {

    this.tileSer.getTileInfo(this.tile).subscribe(
      data => {this.tileObj = data; this.showConfirm(this.tileObj); },
      err => console.log(err));
  }

  showConfirm(inTile: Tile) {
    let disposable = this.dialogService.addDialog(TilepopComponent, {
        tileObj: inTile} ).subscribe();

}


}
