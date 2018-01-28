import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateStationPopComponent } from './create-station-pop.component';

describe('CreateStationPopComponent', () => {
  let component: CreateStationPopComponent;
  let fixture: ComponentFixture<CreateStationPopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateStationPopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateStationPopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
