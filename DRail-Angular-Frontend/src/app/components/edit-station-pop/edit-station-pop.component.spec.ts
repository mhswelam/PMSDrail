import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditStationPopComponent } from './edit-station-pop.component';

describe('EditStationPopComponent', () => {
  let component: EditStationPopComponent;
  let fixture: ComponentFixture<EditStationPopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditStationPopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditStationPopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
