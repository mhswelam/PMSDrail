import {Tile} from '../../models/tile';
import { Component, OnInit, Input } from '@angular/core';
import { Rail } from '../../models/rail';
import { RailService } from '../../services/rail.service';
import { DragulaService } from 'ng2-dragula/ng2-dragula';
import { UserService } from '../../services/user.service';
import { FormGroup } from '@angular/forms/src/model';
import { ValidatorFn,
         Validators,
         AbstractControl,
         FormControl,
         NG_VALIDATORS,
         FormBuilder} from '@angular/forms';
import { TileService } from '../../services/tile.service';


@Component({
  selector: 'app-rail',
  templateUrl: './rail.component.html',
  styleUrls: ['./rail.component.css']
})
export class RailComponent implements OnInit {

  @Input() rail: Rail;
  tiles: Tile[] = [];

  /* Adding Tiles */
  form: FormGroup;
  roleId: number;
  tileTitle: string;
  tilePoints: number;
  tileNote: string;
  statusMessage: string;

  constructor(private railService: RailService, private dragula: DragulaService,
    private userService: UserService, private tileService: TileService, formBuilder: FormBuilder) {
        this.form = formBuilder.group ({
          tileTitle: ['', Validators.required],
          tilePoints: ['', [Validators.required, Validators.min(1), Validators.max(10)]],
          tileNote: ['', Validators.required]
        });
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

  addNewTile() {
    this.statusMessage = '';

    let tile = new Tile(null, this.tileTitle, this.tilePoints, this.tileNote,
                        null, false, this.tiles.length, this.userService.getUser().userId,
                        this.rail.railId, null, null);

    this.tileService.addTile(tile).subscribe (
      response => {
        if (response.status === 201) {
           document.getElementById('tileStatus').setAttribute('style', 'color:green');
           this.statusMessage = 'Tile Created!';
        } else {
          document.getElementById('tileStatus').setAttribute('style', 'color:red');
           this.statusMessage = 'There was an error processing your request.';
        }
      }
    );
  }


}
