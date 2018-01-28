import { Component, OnInit } from '@angular/core';
import { Tile } from '../../models/tile';
import { ConfirmModel } from '../tilepop/tilepop.component';
import { TileService } from '../../services/tile.service';
import { Rail } from '../../models/rail';
import { RailService } from '../../services/rail.service';
import { DialogComponent, DialogService } from 'ng2-bootstrap-modal';
import {  ValidatorFn,
          Validators,
          AbstractControl,
          FormControl,
          NG_VALIDATORS,
          FormBuilder,
          FormGroup} from '@angular/forms';

export interface AddModal {

  railObj: Rail;

}

@Component({
  selector: 'app-addtilepop',
  templateUrl: './addtilepop.component.html',
  styleUrls: ['./addtilepop.component.css']
})
export class AddtilepopComponent extends DialogComponent<AddModal, boolean> implements AddModal {

  railObj: Rail;

  form: FormGroup;
  statusMessage: string;

  tileTitle: string;
  tilePoints: number;
  tileNote: string;


  constructor(dialogService: DialogService, private tileService:TileService, private railService: RailService,
    formBuilder: FormBuilder) {
      super(dialogService);
      this.form = formBuilder.group ({
        tileTitle: ['', Validators.required],
        tilePoints: ['', [Validators.required, Validators.min(1), Validators.max(10)]],
        tileNote: ['', Validators.required]
      });
   }

   addNewTile() {
    this.statusMessage = '';

    let tile = new Tile(null, this.tileTitle, this.tilePoints, this.tileNote,
                        null, false, this.railObj.tileIds.length, null,
                        this.railObj.railId, [], []);

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
